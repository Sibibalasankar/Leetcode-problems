// Last updated: 10/4/2026, 8:38:44 PM
1class Solution {
2    public boolean checkValidString(String s) {
3        int l = 0, h = 0;
4
5        for (int i = 0; i < s.length(); i++) {
6            l += s.charAt(i) == '(' ? 1 : -1;
7            h += s.charAt(i) == ')' ? -1 : 1;
8
9            if (h < 0) return false;
10
11            l = Math.max(l, 0);
12        }
13
14        return l == 0;
15    }
16}