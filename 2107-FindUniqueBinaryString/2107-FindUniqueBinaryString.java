// Last updated: 7/8/2026, 5:01:45 PM
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result =new StringBuilder();
        for(int i=0;i<nums.length;i++){
            result.append(nums[i].charAt(i) == '1' ? '0' : '1');
        }
        return result.toString();
    }
}