// Last updated: 11/2/2026, 10:01:28 PM
1class Solution {
2    private static final Random RNG = new Random();
3
4    public int minMoves2(int[] nums) {
5        int med = quickselect(nums, nums.length / 2), moves = 0;
6        for (int x : nums) moves += Math.abs(x - med);
7        return moves;
8    }
9
10    private static int quickselect(int[] a, int k) {
11        int lo = 0, hi = a.length - 1;
12        while (true) {
13            int pivot = a[lo + RNG.nextInt(hi - lo + 1)];
14            int lt = lo, i = lo, gt = hi;  // a[lo..lt) < pivot, a[lt..i) == pivot, a(gt..hi] > pivot
15            while (i <= gt) {
16                if (a[i] < pivot) swap(a, lt++, i++);
17                else if (a[i] > pivot) swap(a, i, gt--);
18                else i++;
19            }
20            if (k < lt) hi = lt - 1;
21            else if (k > gt) lo = gt + 1;
22            else return pivot;
23        }
24    }
25
26    private static void swap(int[] a, int i, int j) {
27        int t = a[i]; a[i] = a[j]; a[j] = t;
28    }
29}