// Last updated: 10/26/2026, 8:20:24 AM
1class Solution {
2    public int countIslands(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int ans = 0;
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                if (grid[i][j] > 0) {
8                    long s = dfs(grid, i, j);
9                    if (s % k == 0) ans++;
10                }
11            }
12        }
13        return ans;
14    }
15    private long dfs(int[][] grid, int i, int j) {
16        int m = grid.length, n = grid[0].length;
17        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
18        long sum = grid[i][j];
19        grid[i][j] = 0;
20        sum += dfs(grid, i + 1, j);
21        sum += dfs(grid, i - 1, j);
22        sum += dfs(grid, i, j + 1);
23        sum += dfs(grid, i, j - 1);
24        return sum;
25    }
26}