// Last updated: 7/29/2026, 6:11:46 PM
1class Solution {
2    public String smallestPalindrome(String s, int k) {
3        int[] freq = new int[26];
4        for (char c : s.toCharArray()) {
5            freq[c - 'a']++;
6        }
7        
8        int[] half = new int[26];
9        StringBuilder mid = new StringBuilder();
10        int m = 0;
11        
12        for (int i = 0; i < 26; ++i) {
13            if (freq[i] % 2 != 0) {
14                mid.append((char) (i + 'a'));
15            }
16            half[i] = freq[i] / 2;
17            m += half[i];
18        }
19        
20        if (getWays(half, k) < k) {
21            return "";
22        }
23        
24        StringBuilder firstHalf = new StringBuilder();
25        for (int i = 0; i < m; ++i) {
26            for (int c = 0; c < 26; ++c) {
27                if (half[c] > 0) {
28                    half[c]--;
29                    long ways = getWays(half, k);
30                    
31                    if (ways >= k) {
32                        firstHalf.append((char) (c + 'a'));
33                        break;
34                    } else {
35                        k -= ways;
36                        half[c]++;
37                    }
38                }
39            }
40        }
41        
42        StringBuilder res = new StringBuilder(firstHalf);
43        res.append(mid);
44        res.append(firstHalf.reverse());
45        return res.toString();
46    }
47    
48    private long getWays(int[] f, long targetK) {
49        long ways = 1;
50        int currLen = 0;
51        for (int count : f) {
52            if (count > 0) {
53                currLen += count;
54                long n = currLen;
55                long r = count;
56                
57                if (r > n - r) r = n - r;
58                long curNCr = 1;
59                
60                for (int i = 1; i <= r; ++i) {
61                    curNCr = curNCr * (n - i + 1) / i;
62                    if (curNCr > targetK) {
63                        curNCr = targetK + 1;
64                        break;
65                    }
66                }
67                ways *= curNCr;
68                if (ways > targetK) return targetK + 1;
69            }
70        }
71        return ways;
72    }
73}