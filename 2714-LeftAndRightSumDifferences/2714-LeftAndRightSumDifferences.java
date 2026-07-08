// Last updated: 7/8/2026, 5:01:08 PM
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] left= new int[nums.length];
        int[] right = new int[nums.length];
        int[] sum = new int[nums.length];
        int lsum = 0;
        int rsum = 0;

        for(int i = 0;i<left.length;i++){
            left[i] = lsum;
            lsum += nums[i];
        }

        for(int i=left.length-1;i>=0;i--){
            right[i] = rsum;
            rsum += nums[i];

        }
        
        for(int i=0;i<nums.length;i++){
            sum[i] = Math.abs(right[i] - left[i]);
        }

        return sum;
    }
}