// Last updated: 7/8/2026, 5:00:57 PM
import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();

        // Multi-Source BFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    dist[nr][nc] == -1) {

                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        int[][] best = new int[n][n];
        for (int[] row : best)
            Arrays.fill(row, -1);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        pq.offer(new int[]{dist[0][0], 0, 0});
        best[0][0] = dist[0][0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == n - 1 && c == n - 1)
                return safe;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n) {

                    int newSafe = Math.min(safe, dist[nr][nc]);

                    if (newSafe > best[nr][nc]) {
                        best[nr][nc] = newSafe;
                        pq.offer(new int[]{newSafe, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}