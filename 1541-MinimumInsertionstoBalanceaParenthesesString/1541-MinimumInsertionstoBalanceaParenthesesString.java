// Last updated: 10/9/2026, 10:27:17 PM
1class Solution {
2    public int minInsertions(String s) {
3        int open = 0, ans = 0;
4
5        for (int i = 0; i < s.length(); i++) {
6            if (s.charAt(i) == '(') open++;
7            else {
8                // Step 1: make a "))"
9                if (i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
10                else ans++;
11
12                // Step 2: find its '('
13                if (open > 0) open--;
14                else ans++;
15            }
16        }
17
18        return ans + open * 2;
19    }
20}