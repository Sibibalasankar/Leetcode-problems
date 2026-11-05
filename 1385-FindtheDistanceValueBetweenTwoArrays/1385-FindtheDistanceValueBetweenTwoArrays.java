// Last updated: 11/5/2026, 7:02:32 PM
1class Solution {
2    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
3        return (int) Arrays.stream(arr1)
4            .filter(a -> Arrays.stream(arr2).allMatch(b -> Math.abs(a - b) > d))  // no b in [a - d, a + d]
5            .count();
6    }
7}