// Last updated: 9/11/2026, 9:48:02 PM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        Set<Integer> seen = new HashSet<>();
4        int n = digits.length;
5
6        for (int h = 0; h < n; h++) {
7            if (digits[h] == 0) continue;
8
9            for (int t = 0; t < n; t++) {
10                if (t == h) continue;
11
12                for (int u = 0; u < n; u++) {
13                    if (u == h || u == t) continue;
14
15                    if (digits[u] % 2 != 0) continue;
16
17                    int num = digits[h] * 100 + digits[t] * 10 + digits[u];
18                    seen.add(num);
19                }
20            }
21        }
22
23        return seen.size();
24    }
25}