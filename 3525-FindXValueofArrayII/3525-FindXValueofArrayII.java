// Last updated: 9/22/2026, 9:39:31 PM
1class Solution {
2    static class Node {
3        int prod;
4        int[] freq;
5        Node(int k) {
6            prod = 1;
7            freq = new int[k];
8        }
9    }
10    
11    int k;
12    Node[] tree;
13    int[] nums;
14    
15    Node merge(Node L, Node R) {
16        Node res = new Node(k);
17        res.prod = (int)((1L * L.prod * R.prod) % k);
18        System.arraycopy(L.freq, 0, res.freq, 0, k);
19        for (int r = 0; r < k; r++) {
20            if (R.freq[r] != 0) {
21                int nr = (int)((1L * L.prod * r) % k);
22                res.freq[nr] += R.freq[r];
23            }
24        }
25        return res;
26    }
27    
28    void build(int v, int tl, int tr) {
29        if (tl == tr) {
30            tree[v].prod = nums[tl] % k;
31            tree[v].freq[tree[v].prod] = 1;
32            return;
33        }
34        int tm = (tl + tr) / 2;
35        build(v * 2, tl, tm);
36        build(v * 2 + 1, tm + 1, tr);
37        tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
38    }
39    
40    void update(int v, int tl, int tr, int pos, int val) {
41        if (tl == tr) {
42            tree[v].prod = val % k;
43            Arrays.fill(tree[v].freq, 0);
44            tree[v].freq[tree[v].prod] = 1;
45            return;
46        }
47        int tm = (tl + tr) / 2;
48        if (pos <= tm) update(v * 2, tl, tm, pos, val);
49        else update(v * 2 + 1, tm + 1, tr, pos, val);
50        tree[v] = merge(tree[v * 2], tree[v * 2 + 1]);
51    }
52    
53    Node query(int v, int tl, int tr, int l, int r) {
54        if (l > r) return new Node(k);
55        if (l == tl && r == tr) return tree[v];
56        int tm = (tl + tr) / 2;
57        return merge(query(v * 2, tl, tm, l, Math.min(r, tm)),
58                     query(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
59    }
60    
61    public int[] resultArray(int[] nums, int k, int[][] queries) {
62        this.k = k;
63        this.nums = nums;
64        int n = nums.length;
65        tree = new Node[4 * n];
66        for (int i = 0; i < tree.length; i++) tree[i] = new Node(k);
67        build(1, 0, n - 1);
68        int[] ans = new int[queries.length];
69        for (int i = 0; i < queries.length; i++) {
70            int idx = queries[i][0], val = queries[i][1], start = queries[i][2], x = queries[i][3];
71            update(1, 0, n - 1, idx, val);
72            Node res = query(1, 0, n - 1, start, n - 1);
73            ans[i] = res.freq[x];
74        }
75        return ans;
76    }
77}