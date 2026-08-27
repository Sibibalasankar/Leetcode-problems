// Last updated: 8/27/2026, 8:57:44 AM
1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        int n = s.length();
4
5        // Frequency of characters in s
6        int[] cnt = new int[26];
7
8        for (char c : s.toCharArray()) {
9            cnt[c - 'a']++;
10        }
11
12        // Try the position where we make the string greater.
13        // Rightmost position is preferred.
14        for (int i = n - 1; i >= 0; i--) {
15
16            // Rebuild the frequency array for this pivot.
17            int[] remain = cnt.clone();
18
19            // Try to keep target[0 ... i-1] unchanged.
20            boolean possible = true;
21
22            for (int j = 0; j < i; j++) {
23                int x = target.charAt(j) - 'a';
24
25                if (remain[x] == 0) {
26                    possible = false;
27                    break;
28                }
29
30                remain[x]--;
31            }
32
33            if (!possible)
34                continue;
35
36            // At position i, we need the smallest
37            // available character strictly greater than target[i].
38            int targetChar = target.charAt(i) - 'a';
39
40            for (int c = targetChar + 1; c < 26; c++) {
41
42                if (remain[c] == 0)
43                    continue;
44
45                StringBuilder ans = new StringBuilder(target.substring(0, i));
46
47                // Make the first difference here.
48                ans.append((char) ('a' + c));
49
50                remain[c]--;
51
52                // Fill the rest in sorted order.
53                for (int x = 0; x < 26; x++) {
54                    for (int t = 0; t < remain[x]; t++) {
55                        ans.append((char) ('a' + x));
56                    }
57                }
58
59                return ans.toString();
60            }
61        }
62
63        return "";
64    }
65}