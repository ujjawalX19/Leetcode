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
    public boolean isSameTree(TreeNode p, TreeNode q) {
      List<Integer> listP = new ArrayList<>();
        List<Integer> listQ = new ArrayList<>();

        preorder(p, listP);
        preorder(q, listQ);

        return listP.equals(listQ);
    }
     public void preorder(TreeNode node,List<Integer> list){
        if(node==null){
            list.add(null);
            return;
        }
        list.add(node.val);
        preorder(node.left,list);
        
        preorder(node.right,list);

    

        
    }
}