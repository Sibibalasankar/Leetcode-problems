// Last updated: 8/8/2026, 10:05:54 PM
1class Solution {
2    public int[] validSequence(String word1, String word2) {
3
4        char[] s = word1.toCharArray();
5        char[] t = word2.toCharArray();
6
7        int n = s.length;
8        int m = t.length;
9
10        int[] suffix = new int[n + 1];
11
12        int j = m - 1;
13
14        int matched = 0;
15
16        for (int i = n - 1; i >= 0; i--) {
17
18            if (j >= 0 && s[i] == t[j]) {
19                matched++;
20                j--;
21            }
22
23            suffix[i] = matched;
24        }
25
26        int[] ans = new int[m];
27
28        int i = 0;
29        j = 0;
30
31        while (i < n && j < m) {
32
33            if (s[i] == t[j]) {
34
35                ans[j] = i;
36                j++;
37
38            } else {
39
40                if (suffix[i + 1] >= m - j - 1) {
41
42                    ans[j] = i;
43                    j++;
44                    i++;
45                    break;
46                }
47            }
48
49            i++;
50        }
51
52        if (j < m && i == n)
53            return new int[0];
54
55        while (i < n && j < m) {
56
57            if (s[i] == t[j]) {
58                ans[j] = i;
59                j++;
60            }
61
62            i++;
63        }
64
65        if (j != m)
66            return new int[0];
67
68        return ans;
69    }
70}