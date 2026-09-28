// Last updated: 9/28/2026, 6:50:59 PM
1class Solution {
2    public int maxDepth(String s) {
3        int depth = 0;
4        int r = 0;
5        for (char c : s.toCharArray()) {
6            if (c == ')') {
7                depth--;
8                continue;
9            }
10            // Digits and operators
11            if (c != '(') continue;
12            depth++;
13            // New max only possible after '('
14            if (depth > r) r = depth;
15        }
16        return r;
17    }
18}