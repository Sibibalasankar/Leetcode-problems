// Last updated: 9/25/2026, 9:46:42 PM
1class Solution {
2    TreeSet<String> ans = new TreeSet<>();
3
4    void dfs(String s) {
5        int r = s.indexOf('}');
6
7        // No braces left
8        if (r == -1) {
9            ans.add(s);
10            return;
11        }
12
13        // Find matching '{'
14        int l = s.lastIndexOf('{', r);
15
16        String left = s.substring(0, l);
17        String right = s.substring(r + 1);
18
19        // Content inside { }
20        String inside = s.substring(l + 1, r);
21
22        for (String part : inside.split(",")) {
23            dfs(left + part + right);
24        }
25    }
26
27    public List<String> braceExpansionII(String expression) {
28        dfs(expression);
29        return new ArrayList<>(ans);
30    }
31}