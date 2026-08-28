// Last updated: 8/28/2026, 10:33:46 PM
1class Solution {
2    public String lexPalindromicPermutation(String s, String target) {
3        int[] freq = new int[26];
4        for (int i = 0; i < s.length(); i++)
5            freq[s.charAt(i) - 'a']++;
6
7        char center = 0;
8        for (int i = 0; i < 26; i++) {
9            if (freq[i] % 2 != 0) {
10                if (center != 0)
11                    return "";
12                center = (char) ('a' + i);
13                freq[i]--;
14            }
15        }
16
17        int sz = s.length();
18        int half = sz / 2;
19        for (int i = 0; i < half; i++)
20            freq[target.charAt(i) - 'a'] -= 2;
21
22        if (check(freq)) {
23            String head = target.substring(0, half);
24            String rev = new StringBuilder(head).reverse().toString();
25            String tail = "";
26            if (center != 0)
27                tail += center;
28            tail += rev;
29            if (tail.compareTo(target.substring(half)) > 0)
30                return head + tail;
31        }
32
33        for (int i = half - 1; i >= 0; i--) {
34            char w = target.charAt(i);
35            freq[w - 'a'] += 2;
36            if (!check(freq))
37                continue;
38
39            for (int j = (w - 'a') + 1; j < 26; j++) {
40                if (freq[j] == 0)
41                    continue;
42                freq[j] -= 2;
43                StringBuilder answer = new StringBuilder(target.substring(0, i + 1));
44                answer.setCharAt(i, (char) ('a' + j));
45
46                for (int k = 0; k < 26; k++) {
47                    int cnt = freq[k] / 2;
48                    for (int m = 0; m < cnt; m++)
49                        answer.append((char) ('a' + k));
50                }
51
52                String part = new StringBuilder(answer).reverse().toString();
53                if (center != 0)
54                    answer.append(center);
55                answer.append(part);
56                return answer.toString();
57            }
58        }
59
60        return "";
61    }
62
63    boolean check(int[] freq) {
64        for (int v : freq)
65            if (v < 0)
66                return false;
67        return true;
68    }
69}