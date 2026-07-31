// Last updated: 7/31/2026, 1:31:46 PM
1class Solution {
2    public int minimumPushes(String word) {
3        int[] hashTable = new int[26];
4
5        for(char ch : word.toCharArray()){
6            hashTable[ch - 'a']++;
7        }
8
9        int minPushing = 0;
10
11        Arrays.sort(hashTable);
12
13        for(int i = 25, pushCnt = 0; i >= 0; i--){
14            int currEleIdx = 25 - i;
15
16            if(currEleIdx % 8 == 0)
17                pushCnt++;
18
19            minPushing += hashTable[i] * pushCnt;
20        }
21
22        return minPushing;
23    }
24}