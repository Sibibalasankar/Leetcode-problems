// Last updated: 7/8/2026, 5:01:48 PM
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];

        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i];
        }

        int j=0;
        for(int i=nums.length;i<2*nums.length;i++){
            ans[i] = nums[j++];
        }

        return ans;
    }
}