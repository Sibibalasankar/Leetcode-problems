// Last updated: 7/8/2026, 5:02:00 PM
class Solution {
    public int minPairSum(int[] nums) {
        int max = 0;
        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length/2;i++){
            max = Math.max(nums[left++]+nums[right--],max);
        } 
        return max;
    }
}