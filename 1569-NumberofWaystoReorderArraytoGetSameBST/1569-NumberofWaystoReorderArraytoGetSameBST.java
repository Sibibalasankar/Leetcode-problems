// Last updated: 10/18/2026, 10:31:18 PM
1class Solution {
2    private static final long MOD = 1_000_000_007L;
3
4    public int numOfWays(int[] nums) {
5        int n = nums.length;
6        int[] born = new int[n + 2];  // insertion time of each value; the walls 0 and n + 1 come before everything
7        Arrays.fill(born, -1);
8        for (int i = 0; i < n; i++) born[nums[i]] = i;
9
10        long fact = 1, sizes = 1;  // n! and the product of subtree sizes, mod p
11        for (int k = 2; k <= n; k++) fact = fact * k % MOD;
12        int[] stack = new int[n + 2];  // values with increasing insertion times; stack[0] = 0 is the left wall
13        int top = 0;
14        for (int v = 1; v <= n + 1; v++) {
15            while (born[stack[top]] > born[v]) {  // v is the right wall of the value on top
16                top--;
17                sizes = sizes * (v - stack[top] - 1) % MOD;  // and the value below it is the left wall
18            }
19            stack[++top] = v;
20        }
21        return (int) ((fact * power(sizes, MOD - 2) - 1 + MOD) % MOD);  // n! / sizes - 1
22    }
23
24    private long power(long b, long e) {
25        long r = 1;
26        for (b %= MOD; e > 0; e >>= 1, b = b * b % MOD)
27            if ((e & 1) == 1) r = r * b % MOD;
28        return r;
29    }
30}