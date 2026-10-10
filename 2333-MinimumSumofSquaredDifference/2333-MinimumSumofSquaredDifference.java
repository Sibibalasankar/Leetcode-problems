// Last updated: 10/10/2026, 8:58:36 PM
1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int[] d = new int[100001];
4        long k = (long) k1 + k2, sum = 0;
5        int max = 0;
6
7        // Step 1: count the differences
8        for (int i = 0; i < nums1.length; i++) {
9            int x = Math.abs(nums1[i] - nums2[i]);
10            d[x]++;
11            sum += x;
12            max = Math.max(max, x);
13        }
14
15        // Enough budget -> every difference becomes 0
16        if (sum <= k) return 0;
17
18        // Step 2: shave the biggest differences, level by level
19        for (int i = max; i > 0 && k > 0; i--) {
20            long move = Math.min(k, d[i]);
21            d[i] -= move;
22            d[i - 1] += move;
23            k -= move;
24        }
25
26        // Step 3: add up the squares
27        long ans = 0;
28        for (int i = 0; i <= max; i++)
29            ans += (long) i * i * d[i];
30
31        return ans;
32    }
33}