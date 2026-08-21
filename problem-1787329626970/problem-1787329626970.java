// Last updated: 8/21/2026, 9:57:06 PM
1import java.util.Arrays;
2
3class Solution {
4    boolean check(long mid, int[] A, int n, int k) {
5        long tot = 0;
6
7        for (int i = 1; i <= n; i++) {
8            int q = (1 << i) - 1;
9
10            while (q < 1 << n) {
11                long x = 1;
12
13                for (int j = 0; j < n; j++)
14                    if (((q >> j) & 1) != 0)
15                        x = (x / gcd(x, A[j])) * A[j];
16
17                tot += (mid / x) * (((i & 1) << 1) - 1);
18
19                int c = q & -q;
20                int r = q + c;
21                q = (((r ^ q) >> 2) / c) | r;
22            }
23        }
24
25        return tot >= k;
26    }
27
28    public long findKthSmallest(int[] coins, int k) {
29        Arrays.sort(coins);
30
31        int[] A = new int[coins.length];
32        int n = 0;
33
34        for (int c : coins) {
35            boolean flag = true;
36
37            for (int j = 0; j < n; j++)
38                if (c % A[j] == 0) {
39                    flag = false;
40                    break;
41                }
42
43            if (flag)
44                A[n++] = c;
45        }
46
47        long l = k;
48        long r = (long) A[0] * k;
49
50        while (l < r) {
51            long mid = l + (r - l) / 2;
52
53            if (check(mid, A, n, k))
54                r = mid;
55            else
56                l = mid + 1;
57        }
58
59        return l;
60    }
61
62    long gcd(long a, long b) {
63        return b == 0 ? a : gcd(b, a % b);
64    }
65}