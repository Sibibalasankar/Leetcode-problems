// Last updated: 9/1/2026, 6:54:59 PM
1class Solution {
2    public int minMoves(String[] classroom, int energy) {
3        int m = classroom.length;
4        int n = classroom[0].length();
5
6        int sr = -1, sc = -1;
7        int cnt = 0;
8
9        // Give each litter an ID for bitmask
10        int[][] id = new int[m][n];
11        for(int[] row : id) Arrays.fill(row, -1);
12
13        for(int i = 0; i < m; i++){
14            for(int j = 0; j < n; j++){
15                if(classroom[i].charAt(j) == 'S'){
16                    sr = i;
17                    sc = j;
18                }
19                if(classroom[i].charAt(j) == 'L'){
20                    id[i][j] = cnt++;
21                }
22            }
23        }
24
25        int masks = 1 << cnt;
26        int fullMask = masks - 1;
27
28        // best[r][c][mask] = max energy reached at this state
29        int[][][] best = new int[m][n][masks];
30        for(int[][] layer : best)
31            for(int[] row : layer)
32                Arrays.fill(row, -1);
33
34        class State {
35            int r, c, mask, en, dist;
36
37            State(int r, int c, int mask, int en, int dist){
38                this.r = r;
39                this.c = c;
40                this.mask = mask;
41                this.en = en;
42                this.dist = dist;
43            }
44        }
45
46        Queue<State> q = new LinkedList<>();
47
48        q.add(new State(sr, sc, 0, energy, 0));
49        best[sr][sc][0] = energy;
50
51        int[] dr = {-1, 1, 0, 0};
52        int[] dc = {0, 0, -1, 1};
53
54        while(!q.isEmpty()){
55            State cur = q.poll();
56            int r = cur.r;
57            int c = cur.c;
58            int mask = cur.mask;
59            int en = cur.en;
60            int dist = cur.dist;
61
62            // All litter collected
63            if(mask == fullMask){
64                return dist;
65            }
66
67            // No energy, cannot move
68            if(en == 0){
69                continue;
70            }
71
72            for(int d = 0; d < 4; d++){
73                int nr = r + dr[d];
74                int nc = c + dc[d];
75
76                // Outside grid
77                if(nr < 0 || nr >= m || nc < 0 || nc >= n){
78                    continue;
79                }
80
81                // Obstacle
82                if(classroom[nr].charAt(nc) == 'X'){
83                    continue;
84                }
85
86                int newEn = en - 1;
87                int newMask = mask;
88
89                // Collect litter
90                if(classroom[nr].charAt(nc) == 'L'){
91                    newMask |= (1 << id[nr][nc]);
92                }
93
94                // Recharge
95                if(classroom[nr].charAt(nc) == 'R'){
96                    newEn = energy;
97                }
98
99                // Already reached with more energy
100                if(best[nr][nc][newMask] >= newEn){
101                    continue;
102                }
103
104                best[nr][nc][newMask] = newEn;
105
106                q.add(new State(nr, nc, newMask, newEn, dist + 1));
107            }
108        }
109
110        return -1;
111    }
112}