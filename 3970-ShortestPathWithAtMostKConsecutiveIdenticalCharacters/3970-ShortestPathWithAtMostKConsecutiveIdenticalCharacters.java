// Last updated: 10/31/2026, 8:28:54 AM
1class Solution {
2    public int shortestPath(int n, int[][] edges, String labels, int k) {
3        List<int[]>[] graph = new List[n];
4        Arrays.setAll(graph, x -> new ArrayList<>());
5        for (int[] e : edges)
6            graph[e[0]].add(new int[]{e[1], e[2]});
7
8        int[] best = new int[n];  // best[x]: the shortest run x was settled with, k + 1 until then
9        Arrays.fill(best, k + 1);
10        PriorityQueue<long[]> heap = new PriorityQueue<>(Arrays::compare);  // (distance, run, node): the walk ends with run nodes labeled labels[node]
11        heap.add(new long[]{0, 1, 0});
12        while (!heap.isEmpty()) {
13            long[] s = heap.poll();
14            long d = s[0];
15            int run = (int) s[1], x = (int) s[2];
16            if (run >= best[x])  // x was settled before, no farther away and with a run no longer
17                continue;
18            if (x == n - 1)
19                return (int) d;
20            best[x] = run;
21            for (int[] e : graph[x]) {
22                int y = e[0], r = labels.charAt(y) == labels.charAt(x) ? run + 1 : 1;
23                if (r < best[y])
24                    heap.add(new long[]{d + e[1], r, y});
25            }
26        }
27        return -1;
28    }
29}