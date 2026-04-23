import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);

        List<Integer> sorted = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int pos = binarySearch(sorted, nums[i]);
            result[i] = pos;
            sorted.add(pos, nums[i]);
        }

        return Arrays.asList(result);
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}