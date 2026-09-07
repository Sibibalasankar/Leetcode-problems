// Last updated: 9/7/2026, 7:32:45 PM
1class Solution {
2    public int distinctSubseqII(String s) {
3        int n = s.length();
4        int MOD = (int) 1e9 + 7;
5
6        int[] dp = new int[n];
7        Arrays.fill(dp, 1);
8        int result = 0;
9
10        for (int i = 0; i < n; i++) {
11
12            for (int j = 0; j < i; j++) {
13                if (s.charAt(i) != s.charAt(j)) {
14                    dp[i] = (int) ((dp[i] + (long) dp[j]) % MOD);
15                }
16            }
17
18            result = (int) ((result + (long) dp[i]) % MOD);
19        }
20
21        return result;
22    }
23}