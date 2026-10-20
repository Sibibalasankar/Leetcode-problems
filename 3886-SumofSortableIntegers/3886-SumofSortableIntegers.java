// Last updated: 10/20/2026, 6:44:08 PM
1class Solution {
2    public int sortableIntegers(int[] nums) {
3        int n = nums.length;
4
5        int[] desc = new int[n];  // desc[i]: number of descents nums[j] > nums[j + 1] with j < i
6        for (int i = 1; i < n; i++) desc[i] = desc[i - 1] + (nums[i - 1] > nums[i] ? 1 : 0);
7        int[] premax = nums.clone(), sufmin = nums.clone();
8        Arrays.parallelPrefix(premax, Math::max);  // premax[i]: max of nums[0..i]
9        for (int i = n - 2; i >= 0; i--) sufmin[i] = Math.min(sufmin[i], sufmin[i + 1]);  // sufmin[i]: min of nums[i..n-1]
10        boolean[] cut = new boolean[n];  // cut[m]: nums[0..m-1] holds exactly the m smallest values
11        cut[0] = true;
12        for (int m = 1; m < n; m++) cut[m] = premax[m - 1] <= sufmin[m];
13
14        BiPredicate<Integer, Integer> rotatable = (l, r) ->  // nums[l..r] is a rotated sorted run: at most one cyclic descent
15            desc[r] - desc[l] + (nums[r] > nums[l] ? 1 : 0) <= 1;
16        IntPredicate sortable = k ->  // every block starts at a valid cut and can be rotated into order
17            IntStream.iterate(0, l -> l < n, l -> l + k).allMatch(l -> cut[l] && rotatable.test(l, l + k - 1));
18
19        IntStream divisors = IntStream.rangeClosed(1, n).filter(k -> n % k == 0);
20        return divisors.filter(sortable).sum();
21    }
22}