// Last updated: 8/22/2026, 2:08:33 PM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int original = n;
4        int digitSum = 0;
5        int digitProduct = 1;
6
7        while (n > 0) {
8            int digit = n % 10;
9            digitSum += digit;
10            digitProduct *= digit;
11            n /= 10;
12        }
13
14        int divisor = digitSum + digitProduct;
15        return original % divisor == 0;
16    }
17}