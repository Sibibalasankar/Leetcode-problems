// Last updated: 7/8/2026, 5:05:52 PM

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        preorder(p,l1);
        preorder(q,l2);

        return l1.equals(l2);
    }

    public static void preorder(TreeNode root,List l){
        if(root == null){
            l.add("null");
            return ;
        }
        l.add(root.val);

        preorder(root.left,l);
        preorder(root.right,l);
}    
}