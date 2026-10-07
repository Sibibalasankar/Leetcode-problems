// Last updated: 10/7/2026, 7:56:29 PM
1class Solution {
2    public List<String> removeInvalidParentheses(String s) {
3        List<String> res = new ArrayList<>();
4        fwd(s, res, 0, 0);
5
6        return res;
7    }
8
9    private void fwd(String s, List<String> res, int li, int lj) {
10        int bal = 0;
11
12        for (int i = li; i < s.length(); i++) {
13            if (s.charAt(i) == '(') bal++;
14            if (s.charAt(i) == ')') bal--;
15
16            if (bal >= 0) continue;
17
18            for (int j = lj; j <= i; j++)
19                if (s.charAt(j) == ')' && (j == lj || s.charAt(j - 1) != ')'))
20                    fwd(s.substring(0, j) + s.substring(j + 1), res, i, j);
21
22            return;
23        }
24
25        bwd(s, res, s.length() - 1, s.length() - 1);
26    }
27
28    private void bwd(String s, List<String> res, int ri, int rj) {
29        int bal = 0;
30
31        for (int i = ri; i >= 0; i--) {
32            if (s.charAt(i) == ')') bal++;
33            if (s.charAt(i) == '(') bal--;
34
35            if (bal >= 0) continue;
36
37            for (int j = rj; j >= i; j--)
38                if (s.charAt(j) == '(' && (j == rj || s.charAt(j + 1) != '('))
39                    bwd(s.substring(0, j) + s.substring(j + 1), res, i - 1, j - 1);
40
41            return;
42        }
43
44        res.add(s);
45    }
46}