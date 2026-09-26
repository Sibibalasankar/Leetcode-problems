// Last updated: 9/26/2026, 3:13:44 PM
1class Solution {
2    public String evaluate(String s, List<List<String>> K) {
3        Map<String, String> d = new HashMap<>();
4        for (var k : K)
5            d.put(k.get(0), k.get(1));
6        
7        StringBuilder str = new StringBuilder();
8        for (int i = 0; i < s.length(); i++) {
9            if (s.charAt(i) == '(') {
10                int j = s.indexOf(")", i + 1);
11                str.append(d.getOrDefault(s.substring(i + 1, j), "?"));
12                i = j;
13            } else
14                str.append(s.charAt(i));
15        }
16
17        return str.toString();
18    }
19}