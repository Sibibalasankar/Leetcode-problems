// Last updated: 10/12/2026, 8:27:56 PM
1class Solution {
2    public int sumOfSquares(int[] nums) {
3        int ans = 0;
4        for (int i = 1; i <= nums.length; i++) {
5            if (nums.length % i == 0)
6                ans += nums[i - 1] * nums[i - 1];
7        }
8        return ans;
9    }
10}