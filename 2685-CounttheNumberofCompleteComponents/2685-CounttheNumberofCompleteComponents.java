// Last updated: 7/11/2026, 9:03:02 AM
1class Solution {
2
3    int vertices;
4    int degreeSum;
5
6    public int countCompleteComponents(int n, int[][] edges) {
7
8        List<Integer>[] graph = new ArrayList[n];
9
10        for (int i = 0; i < n; i++)
11            graph[i] = new ArrayList<>();
12
13        for (int[] edge : edges) {
14            graph[edge[0]].add(edge[1]);
15            graph[edge[1]].add(edge[0]);
16        }
17
18        boolean[] visited = new boolean[n];
19        int answer = 0;
20
21        for (int i = 0; i < n; i++) {
22
23            if (!visited[i]) {
24
25                vertices = 0;
26                degreeSum = 0;
27
28                dfs(i, graph, visited);
29
30                int actualEdges = degreeSum / 2;
31                int expectedEdges = vertices * (vertices - 1) / 2;
32
33                if (actualEdges == expectedEdges)
34                    answer++;
35            }
36        }
37
38        return answer;
39    }
40
41    void dfs(int node, List<Integer>[] graph, boolean[] visited) {
42
43        visited[node] = true;
44
45        vertices++;
46
47        degreeSum += graph[node].size();
48
49        for (int next : graph[node]) {
50
51            if (!visited[next])
52                dfs(next, graph, visited);
53        }
54    }
55}