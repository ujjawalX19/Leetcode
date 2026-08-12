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
class Solution {
    int count = 0;

    public int goodNodes(TreeNode root) {
        preorder(root, Integer.MIN_VALUE);
        return count;
    }

    void preorder(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            count++;
        }

        max = Math.max(max, node.val);

        preorder(node.left, max);
        preorder(node.right, max);
    }
}