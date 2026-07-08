// Last updated: 7/8/2026, 5:05:28 PM
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num:nums){
            result = result ^ num;
        }
        return result;
    }
}