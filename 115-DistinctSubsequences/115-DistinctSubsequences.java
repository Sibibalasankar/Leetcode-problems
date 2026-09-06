// Last updated: 9/6/2026, 10:27:58 PM
1class Solution {
2    public int numDistinct(String s, String t) {
3        int m = s.length();
4        int n = t.length();
5
6        int[] dp = new int[n + 1];
7
8        for (int i = 1; i <= m; i++) {
9            int last = 1;
10
11            for (int j = 1; j <= n; j++) {
12                int cur = dp[j];
13
14                int take = 0, notTake;
15                if (s.charAt(i - 1) == t.charAt(j - 1)) {
16                    take = last;
17                }
18                notTake = cur;
19
20                dp[j] = (take + notTake);
21                last = cur;
22            }
23        }
24
25        return dp[n];
26    }
27}