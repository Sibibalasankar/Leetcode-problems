// Last updated: 7/11/2026, 9:18:59 AM
1class Solution {
2
3    int[] dp;
4
5    public int fib(int n) {
6
7        dp = new int[n + 1];
8
9        Arrays.fill(dp, -1);
10
11        return solve(n);
12    }
13
14    private int solve(int n) {
15
16        if (n <= 1)
17            return n;
18
19        if (dp[n] != -1)
20            return dp[n];
21
22        dp[n] = solve(n - 1) + solve(n - 2);
23
24        return dp[n];
25    }
26}