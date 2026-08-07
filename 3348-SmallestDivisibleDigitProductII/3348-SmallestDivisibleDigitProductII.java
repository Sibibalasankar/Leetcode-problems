// Last updated: 8/7/2026, 6:47:26 PM
1class Solution {
2    int primes[] = new int[] { 2, 3, 5, 7 };
3    int maxPrime = primes[primes.length - 1];
4
5    public String smallestNumber(String num, long t) {
6        int primeCount[] = new int[maxPrime + 1];
7        int numLength = num.length();
8        int minLength;
9        int firstZeroIndexFromLeft = 0;
10
11        for (int prime : primes) {
12            while (t % prime == 0) {
13                t /= prime;
14                primeCount[prime]++;
15            }
16        }
17
18        if (t != 1) {
19            return "-1";
20        }
21
22        minLength = getMinLength(primeCount);
23
24        if (numLength < minLength) {
25            return buildSuffix(primeCount, minLength, new char[minLength]);
26        }
27
28        char[] result = new char[numLength + 1];
29
30        for (int i = 0; firstZeroIndexFromLeft < numLength
31                && (result[++i] = num.charAt(firstZeroIndexFromLeft)) != '0'; firstZeroIndexFromLeft++) {
32            logNum(primeCount, result[i], -1);
33        }
34
35        if (getMinLength(primeCount) == 0) {
36            if (firstZeroIndexFromLeft == numLength) {
37                return num;
38            }
39            Arrays.fill(result, ++firstZeroIndexFromLeft, result.length, '1');
40            return new String(result, 1, numLength);
41        }
42
43        for (int last = numLength - 1, end = Math.min(firstZeroIndexFromLeft, last); end >= 0; end--) {
44            for (logNum(primeCount, result[end + 1], 1); ++result[end + 1] <= '9'; logNum(primeCount, result[end + 1], 1)) {
45                logNum(primeCount, result[end + 1], -1);
46                if (getMinLength(primeCount) <= last - end) {
47                    return buildSuffix(primeCount, last - end, result);
48                }
49            }
50        }
51
52        return buildSuffix(primeCount, result.length, result);
53    }
54
55    void logNum(int[] primeCount, int num, int value) {
56        if (num < '2') return;
57
58        if (num == '9') primeCount[3] += value << 1;
59        else if (num == '4') primeCount[2] += value << 1;
60        else if (num == '8') primeCount[2] += value * 3;
61        else if (num == '6') {
62            primeCount[2] += value;
63            primeCount[3] += value;
64        } else {
65            primeCount[num - '0'] += value;
66        }
67    }
68
69    String buildSuffix(int[] primeCount, int targetLength, char[] result) {
70        int index = result.length;
71
72        while (primeCount[3] > 1) {
73            primeCount[3] -= 2;
74            result[--index] = '9';
75        }
76
77        while (primeCount[2] > 2) {
78            primeCount[2] -= 3;
79            result[--index] = '8';
80        }
81
82        while (primeCount[7]-- > 0) result[--index] = '7';
83
84        if (primeCount[2] > 0 && primeCount[3] > 0) {
85            result[--index] = '6';
86            primeCount[2]--;
87            primeCount[3]--;
88        }
89
90        while (primeCount[5]-- > 0) result[--index] = '5';
91
92        while (primeCount[2] > 1) {
93            primeCount[2] -= 2;
94            result[--index] = '4';
95        }
96
97        while (primeCount[3] > 0) {
98            primeCount[3]--;
99            result[--index] = '3';
100        }
101
102        while (primeCount[2] > 0) {
103            primeCount[2]--;
104            result[--index] = '2';
105        }
106
107        while (index + targetLength != result.length) {
108            result[--index] = '1';
109        }
110
111        return targetLength == result.length
112                ? new String(result)
113                : new String(result, 1, result.length - 1);
114    }
115
116    int getMinLength(int[] primeCount) {
117        int count2 = Math.max(0, primeCount[2]);
118        int count3 = Math.max(0, primeCount[3]);
119        int count23 = (count3 & 1) + (count2 % 3);
120
121        return (count3 >> 1) + (count2 / 3)
122                + Math.max(0, primeCount[7])
123                + Math.max(0, primeCount[5])
124                + (count23 == 3 ? 2 : count23 > 0 ? 1 : 0);
125    }
126}