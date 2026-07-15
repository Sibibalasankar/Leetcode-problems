// Last updated: 7/15/2026, 4:07:37 PM
1public class Solution {
2    public int numTrees(int n) {
3        int[] dp = new int[n + 1];
4        dp[0] = 1;
5        for (int i = 1; i <= n; i++) {
6            for (int j = 1; j <= i; j++) {
7                dp[i] += dp[j - 1]*dp[i - j];
8            }
9        }
10        return dp[n];
11    }
12}