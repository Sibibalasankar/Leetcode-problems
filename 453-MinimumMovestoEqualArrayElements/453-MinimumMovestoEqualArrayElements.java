// Last updated: 11/1/2026, 4:27:33 PM
1class Solution {
2    public int minMoves(int[] nums) {
3        int sum = 0, min = Integer.MAX_VALUE;
4        for (int x : nums) {
5            sum += x;
6            min = Math.min(min, x);
7        }
8        return sum - nums.length * min;
9    }
10}