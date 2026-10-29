// Last updated: 10/29/2026, 6:09:40 PM
1class Tree {  // Euler tour: the subtree of x is tin[x] .. tout[x] - 1; LCA by a sparse table over the DFS order
2    final int[] parent, tin, tout, order;  // the root is its own parent; order: the nodes in DFS order
3    final int[][] first;  // first[k][i]: the earliest parent among order[i .. i + 2^k - 1]
4
5    Tree(int n, int[][] edges) {
6        int[] degree = new int[n];
7        for (int[] e : edges) {
8            degree[e[0]]++;
9            degree[e[1]]++;
10        }
11        int[][] graph = new int[n][];
12        for (int x = 0; x < n; x++) graph[x] = new int[degree[x]];
13        for (int[] e : edges) {
14            graph[e[0]][--degree[e[0]]] = e[1];
15            graph[e[1]][--degree[e[1]]] = e[0];
16        }
17
18        parent = new int[n];
19        tin = new int[n];
20        tout = new int[n];
21        order = new int[n];
22        int[] stack = new int[2 * n];
23        int top = 0, time = 0;
24        stack[top++] = 0;
25        while (top > 0) {  // DFS without recursion; ~x marks the moment x's subtree is done
26            int x = stack[--top];
27            if (x < 0) {
28                tout[~x] = time;
29                continue;
30            }
31            tin[x] = time;
32            order[time++] = x;
33            stack[top++] = ~x;
34            for (int y : graph[x])
35                if (y != parent[x]) {
36                    parent[y] = x;
37                    stack[top++] = y;
38                }
39        }
40
41        first = new int[32 - Integer.numberOfLeadingZeros(n)][];
42        first[0] = new int[n];
43        for (int i = 0; i < n; i++) first[0][i] = tin[parent[order[i]]];
44        for (int k = 1; k < first.length; k++) {
45            first[k] = new int[n - (1 << k) + 1];
46            for (int i = 0; i < first[k].length; i++) first[k][i] = Math.min(first[k - 1][i], first[k - 1][i + (1 << (k - 1))]);
47        }
48    }
49
50    int lca(int u, int v) {  // the parent that comes first in DFS order among the nodes after u up to v
51        if (u == v) return u;
52        int l = Math.min(tin[u], tin[v]), r = Math.max(tin[u], tin[v]);
53        int k = 31 - Integer.numberOfLeadingZeros(r - l);
54        return order[Math.min(first[k][l + 1], first[k][r - (1 << k) + 1])];
55    }
56}
57
58class RootPaths {  // get(x): XOR of the letter bits from the root down to x
59    private final Tree tree;
60    private final int[] start, fenwick;  // the masks for the initial letters, and a Fenwick tree over the Euler tour with the changes since the start
61
62    RootPaths(Tree tree, int[] bit) {
63        this.tree = tree;
64        start = bit.clone();
65        for (int x : tree.order)  // a parent comes before its children in DFS order
66            if (x != tree.parent[x]) start[x] ^= start[tree.parent[x]];
67        fenwick = new int[bit.length + 1];
68    }
69
70    void flip(int x, int d) {  // XOR d into the root path of every node in x's subtree
71        for (int i : new int[] {tree.tin[x] + 1, tree.tout[x] + 1})  // d starts at x's subtree and cancels out after it
72            for (; i < fenwick.length; i += i & -i) fenwick[i] ^= d;
73    }
74
75    int get(int x) {
76        int mask = start[x];
77        for (int i = tree.tin[x] + 1; i > 0; i -= i & -i) mask ^= fenwick[i];
78        return mask;
79    }
80}
81
82class Solution {
83    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
84        Tree tree = new Tree(n, edges);
85        int[] bit = new int[n];  // bit[x]: the bit of x's letter
86        for (int x = 0; x < n; x++) bit[x] = 1 << (s.charAt(x) - 'a');
87        RootPaths paths = new RootPaths(tree, bit);
88
89        List<Boolean> ans = new ArrayList<>();
90        for (String q : queries) {
91            int end = q.length();
92            if (q.charAt(0) == 'u') {  // "update x c"
93                int x = Integer.parseInt(q, 7, end - 2, 10), newBit = 1 << (q.charAt(end - 1) - 'a');
94                paths.flip(x, bit[x] ^ newBit);  // the new letter changes the root path of every node in x's subtree
95                bit[x] = newBit;
96            } else {  // "query u v"
97                int space = q.indexOf(' ', 6);
98                int u = Integer.parseInt(q, 6, space, 10), v = Integer.parseInt(q, space + 1, end, 10);
99                int mask = paths.get(u) ^ paths.get(v) ^ bit[tree.lca(u, v)];  // the LCA cancels out in get(u) ^ get(v), so add it back
100                ans.add(Integer.bitCount(mask) <= 1);  // at most one letter is odd
101            }
102        }
103        return ans;
104    }
105}