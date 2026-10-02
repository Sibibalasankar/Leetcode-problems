// Last updated: 10/2/2026, 10:57:09 AM
1class Solution {
2    List<String> res = new ArrayList<>();
3
4    public List<String> generateParenthesis(int n) {
5        if (n-- == 1) return List.of("()");
6        dfs(n, n, "(");
7
8        return res;
9    }
10
11    private void dfs(int O, int C, String s) {
12        if (O == 0 && C == 0) {
13            res.add(s + ")");
14            return;
15        }
16
17        if (O > 0)
18            dfs(O - 1, C, s + "(");
19
20        if (C >= O)
21            dfs(O, C - 1, s + ")");
22    }
23}