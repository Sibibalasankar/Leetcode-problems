// Last updated: 11/3/2026, 9:38:34 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int max = 0;
4        int sum = 0;
5        for (int x : nums) {
6            max = Math.max(max, x);
7            sum += x;
8        }
9        return max * nums.length - sum;
10    }
11}