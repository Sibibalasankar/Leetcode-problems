// Last updated: 11/4/2026, 7:51:59 PM
1class Solution {
2    public long minOperations(int[] nums, int x, int k) {
3        int n = nums.length;
4        int[] vals = nums.clone();
5        Arrays.sort(vals);
6        int m = 0;
7        for (int i = 0; i < n; i++) {
8            if (m == 0 || vals[i] != vals[m - 1]) {
9                vals[m++] = vals[i];
10            }
11        }
12        int[] rk = new int[n];
13        for (int i = 0; i < n; i++) {
14            rk[i] = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;
15        }
16        int[] cnt = new int[m + 1];
17        long[] sm = new long[m + 1];
18        int top = 1;
19        while (top * 2 <= m) top *= 2;
20        int need = (x + 1) / 2;
21        int w = n - x + 1;
22        long[] cost = new long[w];
23        long total = 0;
24        for (int i = 0; i < n; i++) {
25            total += nums[i];
26            for (int p = rk[i]; p <= m; p += p & -p) {
27                cnt[p] += 1;
28                sm[p] += nums[i];
29            }
30            if (i >= x) {
31                total -= nums[i - x];
32                for (int p = rk[i - x]; p <= m; p += p & -p) {
33                    cnt[p] -= 1;
34                    sm[p] -= nums[i - x];
35                }
36            }
37            if (i >= x - 1) {
38                int pos = 0, rem = need;
39                long s0 = 0;
40                for (int pw = top; pw > 0; pw >>= 1) {
41                    int nxt = pos + pw;
42                    if (nxt <= m && cnt[nxt] < rem) {
43                        pos = nxt;
44                        rem -= cnt[nxt];
45                        s0 += sm[nxt];
46                    }
47                }
48                long med = vals[pos];
49                long c0 = need - rem;
50                cost[i - x + 1] = med * c0 - s0 + (total - s0) - med * (x - c0);
51            }
52        }
53        long INF = 1000000000000000000L;
54        long[] prev = new long[n + 1];
55        long[] cur = new long[n + 1];
56        for (int j = 0; j < k; j++) {
57            for (int i = 0; i < x; i++) cur[i] = INF;
58            for (int i = x; i <= n; i++) {
59                long a = cur[i - 1];
60                long b = prev[i - x] + cost[i - x];
61                cur[i] = a < b ? a : b;
62            }
63            long[] t = prev;
64            prev = cur;
65            cur = t;
66        }
67        return prev[n];
68    }
69}