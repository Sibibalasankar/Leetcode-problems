// Last updated: 10/8/2026, 8:00:40 PM
1class Solution {
2    public String removeOuterParentheses(String s) {
3        StringBuilder sb = new StringBuilder();
4        int lvl = 0;
5
6        for (int i = 0; i < s.length(); i++)
7            if ((s.charAt(i) == '(' ? lvl++ : --lvl) > 0)
8                sb.append(s.charAt(i));
9
10        return sb.toString();
11    }
12}