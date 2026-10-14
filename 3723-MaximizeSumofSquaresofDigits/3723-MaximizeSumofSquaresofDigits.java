// Last updated: 10/14/2026, 7:07:53 PM
1class Solution {
2    public String maxSumOfSquares(int num, int sum) {
3        if (sum > 9 * num) return "";  // even all 9s can't reach the sum
4        int nines = sum / 9, rest = sum % 9;
5        return ("9".repeat(nines) + rest + "0".repeat(num)).substring(0, num);  // 9s, then the rest, then zeros
6    }
7}