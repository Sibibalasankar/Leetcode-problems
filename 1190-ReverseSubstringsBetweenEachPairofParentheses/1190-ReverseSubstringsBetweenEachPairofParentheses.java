// Last updated: 9/28/2026, 6:50:17 PM
1class Solution {
2    public String reverseParentheses(String s) {
3        int n = s.length();
4        int[] link = new int[n];
5        Stack<Integer> stk = new Stack<>();
6
7        for (int i = 0; i < n; i++) {
8            if (s.charAt(i) == '(')
9                stk.push(i);
10            else if (s.charAt(i) == ')') {
11                link[i] = stk.pop();
12                link[link[i]] = i;
13            }
14        }
15
16        StringBuilder sb = new StringBuilder();
17        for (int i = 0, dir = 1; i < n; i += dir) {
18            if (s.charAt(i) >= 'a')
19                sb.append(s.charAt(i));
20            else {
21                i = link[i];
22                dir = -dir;
23            }
24        }
25        
26        return sb.toString();
27    }
28}