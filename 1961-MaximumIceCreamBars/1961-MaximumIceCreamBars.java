// Last updated: 7/8/2026, 5:02:07 PM
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        int count = 0;
        for(int i:costs){
            System.out.print(i+" ");
            if(res+i <= coins){
                res+=i;
                count++;
            }
        }
        return count;
    }
}