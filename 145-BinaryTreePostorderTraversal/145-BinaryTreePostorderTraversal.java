// Last updated: 7/8/2026, 5:05:13 PM
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;        
    }

    private void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}