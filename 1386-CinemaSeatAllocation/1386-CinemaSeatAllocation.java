// Last updated: 8/19/2026, 7:00:50 PM
1import java.util.HashMap;
2import java.util.Map;
3
4public class Solution {
5    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
6        Map<Integer, Integer> graph = new HashMap<>();
7        
8        for (int[] seat : reservedSeats) {
9            int row = seat[0];
10            int col = seat[1];
11            if (col >= 2 && col <= 9) {
12                int mask = graph.getOrDefault(row, 0);
13                mask |= (1 << (col - 2));
14                graph.put(row, mask);
15            }
16        }
17        
18        // Base case: Assume 2 families per empty row
19        int maxFamilies = 2 * n; 
20        
21        for (int mask : graph.values()) {
22            boolean left = (mask & 15) == 0;    // Seats 2,3,4,5 (bits 0-3)
23            boolean right = (mask & 240) == 0;  // Seats 6,7,8,9 (bits 4-7)
24            boolean mid = (mask & 60) == 0;     // Seats 4,5,6,7 (bits 2-5)
25            
26            maxFamilies -= 2; // Deduct default 2 families
27            
28            if (left && right) {
29                maxFamilies += 2;
30            } else if (left || right || mid) {
31                maxFamilies += 1;
32            }
33        }
34        
35        return maxFamilies;
36    }
37}