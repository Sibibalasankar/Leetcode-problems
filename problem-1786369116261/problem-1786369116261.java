// Last updated: 8/10/2026, 7:08:36 PM
1class Solution {
2    public boolean winnerSquareGame(int n) {
3
4        boolean[] dp = new boolean[n + 1];
5
6        for (int i = 0; i <= n; i++) {
7
8            // If i is a losing position,
9            // every valid square move from i
10            // creates a winning position.
11            if (!dp[i]) {
12
13                for (int j = 1; i + j * j <= n; j++) {
14                    dp[i + j * j] = true;
15                }
16
17                // Once n becomes reachable from a losing position,
18                // the first player can force a win.
19                if (dp[n]) {
20                    return true;
21                }
22            }
23        }
24
25        return false;
26    }
27}