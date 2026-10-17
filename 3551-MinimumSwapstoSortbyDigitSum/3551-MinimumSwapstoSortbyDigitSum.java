// Last updated: 10/17/2026, 7:58:28 PM
1class Solution {
2    public int minSwaps(int[] nums) {
3        int n = nums.length;
4        long[] keyed = new long[n];  // digit sum in the high bits, value in the low bits
5        for (int i = 0; i < n; i++) keyed[i] = (long) digitSum(nums[i]) << 32 | nums[i];
6        Arrays.sort(keyed);
7        Map<Integer, Integer> rank = new HashMap<>();  // final position of each value
8        for (int k = 0; k < n; k++) rank.put((int) keyed[k], k);
9        int[] home = new int[n];  // where the value at each position must go
10        for (int i = 0; i < n; i++) home[i] = rank.get(nums[i]);
11
12        int swaps = 0;
13        for (int i = 0; i < n; i++) {
14            while (home[i] != i) {  // send the value at i home, take that spot's value in exchange
15                int j = home[i];
16                home[i] = home[j];
17                home[j] = j;
18                swaps++;
19            }
20        }
21        return swaps;
22    }
23
24    private int digitSum(int x) {
25        int s = 0;
26        for (; x > 0; x /= 10) s += x % 10;
27        return s;
28    }
29}