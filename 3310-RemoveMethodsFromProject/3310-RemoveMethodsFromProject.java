// Last updated: 8/5/2026, 1:48:23 PM
1class Solution {
2    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
3        List<Integer>[] adj = new ArrayList[n];
4
5        for (int i = 0; i < n; i++) {
6            adj[i] = new ArrayList<>();
7        }
8
9        for (int[] edge : invocations) {
10            int u = edge[0];
11            int v = edge[1];
12
13            adj[u].add(v);
14        }
15
16        boolean[] suspicious = new boolean[n];
17        suspicious[k] = true;
18
19        Queue<Integer> queue = new ArrayDeque<>();
20        queue.offer(k);
21
22        while (!queue.isEmpty()) {
23            int u = queue.poll();
24
25            for (int v : adj[u]) {
26                if (!suspicious[v]) {
27                    suspicious[v] = true;
28                    queue.offer(v);
29                }
30            }
31        }
32
33        for (int[] edge : invocations) {
34            int u = edge[0];
35            int v = edge[1];
36
37            if (!suspicious[u] && suspicious[v]) {
38                List<Integer> allMethods = new ArrayList<>();
39
40                for (int i = 0; i < n; i++) {
41                    allMethods.add(i);
42                }
43
44                return allMethods;
45            }
46        }
47
48        List<Integer> result = new ArrayList<>();
49
50        for (int i = 0; i < n; i++) {
51            if (!suspicious[i]) {
52                result.add(i);
53            }
54        }
55
56        return result;
57    }
58}