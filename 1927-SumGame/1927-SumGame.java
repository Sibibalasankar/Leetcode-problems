// Last updated: 8/23/2026, 4:30:09 PM
1class Solution {
2    public boolean sumGame(String A) {
3        int[] sum = {0, 0}, q = {0, 0};
4        int n = A.length();
5
6        for (int i = 0; i < n; i++) {
7            int j = i / (n >> 1);
8            if (A.charAt(i) == '?')
9                q[j]++;
10            else
11                sum[j] += A.charAt(i) - '0';
12        }
13
14        return ((q[0] + q[1]) % 2 == 1) ||
15               ((sum[0] - sum[1]) << 1) != (q[1] - q[0]) * 9;
16    }
17}