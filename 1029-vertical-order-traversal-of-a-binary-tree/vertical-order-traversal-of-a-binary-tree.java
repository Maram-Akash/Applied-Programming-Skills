/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {

    class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<NodeInfo> list = new ArrayList<>();

        // DFS traversal
        dfs(root, 0, 0, list);

        // Sort by column, then row, then value
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col)
                return a.col - b.col;
            if (a.row != b.row)
                return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for (NodeInfo node : list) {
            if (node.col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = node.col;
            }
            result.get(result.size() - 1).add(node.val);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<NodeInfo> list) {
        if (node == null)
            return;

        list.add(new NodeInfo(row, col, node.val));

        dfs(node.left, row + 1, col - 1, list);
        dfs(node.right, row + 1, col + 1, list);
    }
}
