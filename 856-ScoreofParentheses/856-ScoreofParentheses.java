// Last updated: 10/5/2026, 7:22:24 PM
1class Solution {
2    public int scoreOfParentheses(String S) {
3        return F(S, 0, S.length());
4    }
5
6    private int F(String S, int i, int j) {
7        int ans = 0, bal = 0;
8
9        // Split string into primitives
10        for (int k = i; k < j; ++k) {
11            bal += S.charAt(k) == '(' ? 1 : -1;
12            if (bal == 0) {
13                if (k - i == 1) {
14                    ans++;
15                } else {
16                    ans += 2 * F(S, i + 1, k);
17                }
18                // Move start pointer for the next primitive
19                i = k + 1; 
20            }
21        }
22
23        return ans;
24    }
25}