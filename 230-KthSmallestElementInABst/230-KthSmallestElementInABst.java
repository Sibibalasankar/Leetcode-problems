// Last updated: 7/8/2026, 5:04:53 PM

class Solution {

    int answer = 0;
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return answer;
    }

    public void inorder(TreeNode root,int k){
        if(root == null){
            return;
        }
            inorder(root.left,k);
            count++;
            if(count == k){
                answer = root.val;
                return;
            }
            inorder(root.right,k);
    }
}