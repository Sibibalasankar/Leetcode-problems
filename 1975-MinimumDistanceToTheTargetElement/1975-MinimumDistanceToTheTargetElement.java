// Last updated: 7/8/2026, 5:02:03 PM
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(start - i));
            }
        }

        return min;
    }
}