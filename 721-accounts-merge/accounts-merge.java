import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> owner = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                parent.putIfAbsent(acc.get(i), acc.get(i));
                owner.put(acc.get(i), name);
                union(parent, acc.get(1), acc.get(i));
            }
        }

        Map<String, TreeSet<String>> map = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (String root : map.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(owner.get(root));
            list.addAll(map.get(root));
            res.add(list);
        }
        return res;
    }

    private String find(Map<String, String> parent, String x) {
        if (!parent.get(x).equals(x))
            parent.put(x, find(parent, parent.get(x)));
        return parent.get(x);
    }

    private void union(Map<String, String> parent, String x, String y) {
        parent.put(find(parent, x), find(parent, y));
    }
}