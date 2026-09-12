// Last updated: 9/12/2026, 9:00:29 AM
1class Solution {
2    public int[] maximumWeight(List<List<Integer>> intervals) {
3        int n = intervals.size();
4        int[][] arr = new int[n][4];
5        
6        for (int i = 0; i < n; i++) {
7            arr[i][0] = intervals.get(i).get(0);
8            arr[i][1] = intervals.get(i).get(1);
9            arr[i][2] = intervals.get(i).get(2);
10            arr[i][3] = i;
11        }
12        
13        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
14        
15        long[][] dpWeight = new long[n + 1][5];
16        List<Integer>[][] dpList = new ArrayList[n + 1][5];
17        
18        for (int i = 0; i <= n; i++) 
19            for (int k = 0; k <= 4; k++) 
20                dpList[i][k] = new ArrayList<>();
21        
22        for (int i = 1; i <= n; i++) {
23            int l = arr[i - 1][0];
24            long w = arr[i - 1][2];
25            int id = arr[i - 1][3];
26            
27            int low = 1, high = i - 1, prev = 0;
28            while (low <= high) {
29                int mid = low + (high - low) / 2;
30                if (arr[mid - 1][1] < l) {
31                    prev = mid;
32                    low = mid + 1;
33                } else 
34                    high = mid - 1;
35            }
36            
37            for (int k = 1; k <= 4; k++) {
38                long skipW = dpWeight[i - 1][k];
39                List<Integer> skipList = dpList[i - 1][k];
40                
41                long takeW = dpWeight[prev][k - 1] + w;
42                List<Integer> takeList = new ArrayList<>(dpList[prev][k - 1]);
43                takeList.add(id);
44                Collections.sort(takeList);
45                
46                if (takeW > skipW) {
47                    dpWeight[i][k] = takeW;
48                    dpList[i][k] = takeList;
49                } else if (takeW == skipW) {
50                    if (isLexicographicallySmaller(takeList, skipList)) {
51                        dpWeight[i][k] = takeW;
52                        dpList[i][k] = takeList;
53                    } else {
54                        dpWeight[i][k] = skipW;
55                        dpList[i][k] = skipList;
56                    }
57                } else {
58                    dpWeight[i][k] = skipW;
59                    dpList[i][k] = skipList;
60                }
61            }
62        }
63        
64        List<Integer> resultList = dpList[n][4];
65        int[] result = new int[resultList.size()];
66        
67        for (int i = 0; i < resultList.size(); i++) 
68            result[i] = resultList.get(i);
69        
70        return result;
71    }
72    
73    private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
74        int size = Math.min(a.size(), b.size());
75        for (int i = 0; i < size; i++) 
76            if (!a.get(i).equals(b.get(i))) 
77                return a.get(i) < b.get(i);
78                
79        return a.size() < b.size();
80    }
81}