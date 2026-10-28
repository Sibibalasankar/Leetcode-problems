// Last updated: 10/28/2026, 9:35:17 AM
1class Solution {
2    public int minCost(int[][] grid) {
3        int n = grid[0].length;
4        boolean[][] dp = new boolean[n][1024];  // dp[j][x]: XOR x can reach column j of the row above
5        dp[0][0] = true;
6        for (int[] row : grid)
7            for (int j = 0; j < n; j++) {
8                boolean[] next = new boolean[1024];
9                for (int x = 0; x < 1024; x++)
10                    if (dp[j][x] || j > 0 && dp[j - 1][x]) next[x ^ row[j]] = true;  // from above or from the left
11                dp[j] = next;
12            }
13        int x = 0;
14        while (!dp[n - 1][x]) x++;
15        return x;
16    }
17}