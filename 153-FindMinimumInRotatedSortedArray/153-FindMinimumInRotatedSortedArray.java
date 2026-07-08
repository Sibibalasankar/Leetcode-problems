// Last updated: 7/8/2026, 5:05:08 PM
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int last = nums[n];
        int left = 0, right = n;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > last) left = mid + 1;
            else right = mid;
        }

        return nums[left];
    }
}