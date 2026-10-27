// Last updated: 10/27/2026, 7:58:23 PM
1class Solution {
2    public String[] createGrid(int m, int n) {
3        char[][] grid = new char[m][n];
4        
5        for (char[] row : grid)
6            Arrays.fill(row, '#');
7            
8        int r = 0, c = 0;
9        grid[r][c] = '.';
10        
11        while (r < m - 1 || c < n - 1) {
12            if (r < m - 1 && (c == n - 1 || Math.abs((r + 1) * (n - 1) - c * (m - 1)) <= Math.abs(r * (n - 1) - (c + 1) * (m - 1))))
13                r++;
14            else
15                c++;
16                
17            grid[r][c] = '.';
18        }
19        
20        String[] res = new String[m];
21        
22        for (int i = 0; i < m; i++)
23            res[i] = new String(grid[i]);
24            
25        return res;
26    }
27}