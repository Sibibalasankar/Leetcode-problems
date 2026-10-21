// Last updated: 10/21/2026, 7:50:00 PM
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        char min = s.charAt(0), max = s.charAt(0);
5        boolean isSorted = true;
6
7        for (int i = 1; i < n; i++) {
8            if (s.charAt(i) < s.charAt(i - 1)) isSorted = false;
9            if (s.charAt(i) < min) min = s.charAt(i);
10            if (s.charAt(i) > max) max = s.charAt(i);
11        }
12
13        if (isSorted) return 0;
14        if (n == 2) return -1;
15        if (s.charAt(0) == min || s.charAt(n - 1) == max)
16            return 1;
17
18        for (int i = 1; i < n - 1; i++)
19            if (s.charAt(i) == min || s.charAt(i) == max)
20                return 2;
21
22        return 3;
23    }
24}