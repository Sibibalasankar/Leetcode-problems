// Last updated: 9/9/2026, 9:59:02 PM
1class Solution {
2    public long countCommas(long n) {
3        long count = 0;
4
5        for (long p = 1000; p <= n; p *= 1000)
6            count += n - p + 1;
7
8        return count;
9    }
10}