// Last updated: 8/18/2026, 9:27:40 PM
1class Solution {
2    public int largestInteger(int[] A, int k) {
3        int[] f = new int[51];
4        for (int x : A)
5            f[x]++;
6
7        int res = -1, n = A.length;
8        for (int i = 0; i < n; i++) 
9            if (k == n || (f[A[i]] == 1 && (k == 1 || i == 0 || i == n - 1)))
10                res = Math.max(res, A[i]);
11
12        return res;
13    }
14}