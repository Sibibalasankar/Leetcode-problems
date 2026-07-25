// Last updated: 7/25/2026, 10:14:48 PM
1class Solution {
2    public int maxProduct(int n) {
3        int max1 = -1 , max2 = -1;
4        while(n != 0){
5            int rem = n % 10;
6            if(max1 <= rem){
7                max2 = max1;
8                max1 = rem;
9            }
10            else if(max2 < rem){
11                max2 = rem;
12            }
13            n /= 10;
14        }
15        return max1 * max2;
16    }
17}