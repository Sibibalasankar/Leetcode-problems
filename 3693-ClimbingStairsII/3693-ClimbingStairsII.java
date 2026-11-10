// Last updated: 11/10/2026, 4:15:08 PM
1class Solution {
2    public int climbStairs(int n, int[] costs) {
3        costs = IntStream.concat(IntStream.of(0), Arrays.stream(costs)).toArray();
4        int a = costs[n], b = Integer.MAX_VALUE / 2, c = Integer.MAX_VALUE / 2;  // dp[i + 1], dp[i + 2], dp[i + 3] for i = n - 1
5        for (int i = n - 1; i >= 0; i--) {
6            int cur = costs[i] + Math.min(a + 1, Math.min(b + 4, c + 9));  // dp[i]
7            c = b;
8            b = a;
9            a = cur;
10        }
11        return a;
12    }
13}