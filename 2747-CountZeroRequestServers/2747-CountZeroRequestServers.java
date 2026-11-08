// Last updated: 11/8/2026, 8:21:44 AM
1class Solution {
2    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
3        int[][] reqs = Arrays.copyOf(logs, logs.length + 1);
4        reqs[logs.length] = new int[] {0, Integer.MAX_VALUE};  // sentinel: no window ever reaches it
5        Arrays.sort(reqs, 0, logs.length, Comparator.comparingInt(r -> r[1]));  // by time, the sentinel stays last
6        Integer[] order = new Integer[queries.length];
7        Arrays.setAll(order, i -> i);
8        Arrays.sort(order, Comparator.comparingInt(i -> queries[i]));  // query positions in time order
9
10        int[] cnt = new int[n + 1], ans = new int[queries.length];  // cnt: requests per server inside the window [q - x, q]
11        int busy = 0, lo = 0, hi = 0;  // busy: servers with at least one request in it
12        for (int i : order) {
13            int q = queries[i];
14            for (; reqs[hi][1] <= q; hi++)  // requests up to q come in
15                if (cnt[reqs[hi][0]]++ == 0) busy++;
16            for (; reqs[lo][1] < q - x; lo++)  // requests before q - x go out
17                if (--cnt[reqs[lo][0]] == 0) busy--;
18            ans[i] = n - busy;
19        }
20        return ans;
21    }
22}