// Last updated: 7/30/2026, 5:51:45 PM
1class Solution {
2    public int minimumPushes(String A) {
3        int q = A.length() >> 3;
4        int r = A.length() & 7;
5        return ((q << 2) + r) * (q + 1);
6    }
7}