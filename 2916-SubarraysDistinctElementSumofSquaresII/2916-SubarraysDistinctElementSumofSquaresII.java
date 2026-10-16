// Last updated: 10/16/2026, 11:37:03 PM
1class Solution {
2    public int sumCounts(int[] nums) {
3        final long MOD = 1_000_000_007;
4        int n = nums.length;
5        long[] cnt = new long[n + 1], tot = new long[n + 1];  // Fenwick trees over previous-copy positions, stored right to left
6        Map<Integer, Integer> last = new HashMap<>();
7        long ans = 0;
8        for (int r = 0; r < n; r++) {
9            int p = last.getOrDefault(nums[r], -1);
10            long c = 0, s = 0;
11            for (int i = n - p - 1; i > 0; i -= i & -i) {  // boxes 1..n-p-1 hold the positions > p
12                c += cnt[i];
13                s += tot[i];
14            }
15            long gain = (long) (r - p) * (r - p) - 2 * (s - p * c);  // at most 1e10
16            ans = (ans + (n - r) * gain) % MOD;
17            for (int i = n - p; i <= n; i += i & -i) {  // insert p; p = -1 lands past the end and is skipped
18                cnt[i]++;
19                tot[i] += p;
20            }
21            last.put(nums[r], r);
22        }
23        return (int) ans;
24    }
25}