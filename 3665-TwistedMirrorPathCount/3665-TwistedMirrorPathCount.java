// Last updated: 10/31/2026, 8:29:27 AM
1class Solution {
2    public int uniquePaths(int[][] grid) {
3        final int mod = 1_000_000_007;
4        int[] down = new int[grid[0].length];  // ways to enter each cell from above
5        down[0] = 1;
6        for (int[] row : grid) {
7            int right = 0;  // ways to enter the current cell from the left
8            for (int j = 0; j < row.length; j++) {
9                if (row[j] == 1) {  // a mirror swaps the flows
10                    int t = right;
11                    right = down[j];
12                    down[j] = t;
13                } else {  // an empty cell merges them
14                    right = down[j] = (right + down[j]) % mod;
15                }
16            }
17        }
18        return down[down.length - 1];
19    }
20}