// Last updated: 10/3/2026, 10:26:21 AM
1class Solution {
2    public int longestValidParentheses(String s) {
3        Stack<Integer> st = new Stack<>();
4        int res = 0;
5        st.push(-1);
6
7        for (int i = 0; i < s.length(); i++) {
8            if (s.charAt(i) == '(') {
9                st.push(i);
10            } else {
11                st.pop();
12                if (st.isEmpty())
13                    st.push(i);
14                else
15                    res = Math.max(res, i - st.peek());
16            }
17        }
18        return res;
19    }
20}