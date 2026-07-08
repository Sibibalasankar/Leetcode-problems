// Last updated: 7/8/2026, 5:02:13 PM
class Solution {
    public int minOperations(String s) {
        int count =0 , n=s.length();
        for(int i=0;i<n;i++)
            count += (s.charAt(i)^i) & 1;
        return Math.min(count,n-count);    
        
    }
}