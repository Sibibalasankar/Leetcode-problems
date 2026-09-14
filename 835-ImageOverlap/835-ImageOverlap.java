// Last updated: 9/14/2026, 8:41:12 PM
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        // collect every coordinate that holds a 1
5        List<int[]> A = new ArrayList<>();
6        List<int[]> B = new ArrayList<>();
7        for (int i = 0; i < n; ++i) {
8            for (int j = 0; j < n; ++j) {
9                if (img1[i][j] == 1) A.add(new int[]{i, j});
10                if (img2[i][j] == 1) B.add(new int[]{i, j});
11            }
12        }
13        int[][] cnt = new int[2 * n][2 * n];
14        int best = 0;
15        for (int[] a : A) {
16            for (int[] b : B) {
17                int dx = b[0] - a[0] + n;
18                int dy = b[1] - a[1] + n;
19                best = Math.max(best, ++cnt[dx][dy]);
20            }
21        }
22        return best;
23    }
24}