// Last updated: 7/8/2026, 5:01:54 PM
1class Solution {
2        public int peakIndexInMountainArray(int[] A) {
3        int l = 0, r = A.length - 1, m;
4        while (l < r) {
5            m = (l + r) / 2;
6            if (A[m] < A[m + 1])
7                l = m + 1;
8            else
9                r = m;
10        }
11        return l;
12    }
13}