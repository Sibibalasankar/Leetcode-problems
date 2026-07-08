// Last updated: 7/8/2026, 5:04:00 PM
class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sorting array based on second element b
        // initially : [[1,2],[7,8],[4,5]]
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Now: [[1,2],[4,5],[7,8]]

        int chain = 0;
        int last = Integer.MIN_VALUE;

        // Greedily increasing the chain length; 
        for (int[] pair : pairs) {
            if (pair[0] > last) {
                chain++;
                last = pair[1];
            }
        }

        return chain;
    }
}