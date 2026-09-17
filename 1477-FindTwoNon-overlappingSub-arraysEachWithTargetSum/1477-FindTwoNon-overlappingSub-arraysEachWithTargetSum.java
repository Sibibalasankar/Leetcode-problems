// Last updated: 9/17/2026, 9:34:47 PM
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n=arr.length,i=0,j=0,sum=0,bestLen=Integer.MAX_VALUE,result=Integer.MAX_VALUE;
4        int[]minTillIndex=new int[n];
5        Arrays.fill(minTillIndex,Integer.MAX_VALUE);
6        while(j<n){
7            sum+=arr[j];
8            while(i<j&&sum>target){
9                sum-=arr[i++];
10            }
11            if(target==sum){
12                int len=j-i+1;
13                if(i>0&&minTillIndex[i-1]!=Integer.MAX_VALUE)result= Math.min(result,len+minTillIndex[i-1]);
14                bestLen=Math.min(len,bestLen);
15            }
16            minTillIndex[j]=bestLen;
17            j++;
18        }
19        return result==Integer.MAX_VALUE?-1:result;
20    }
21}