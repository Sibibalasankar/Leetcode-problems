// Last updated: 9/19/2026, 8:41:45 PM
1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter,
3                                int x1, int y1, int x2, int y2) {
4
5        // Find the closest point of rectangle to circle center
6        int closestX = Math.max(x1, Math.min(xCenter, x2));
7        int closestY = Math.max(y1, Math.min(yCenter, y2));
8
9        // Calculate squared distance
10        int dx = xCenter - closestX;
11        int dy = yCenter - closestY;
12
13        // Check if closest point is inside/on circle
14        return dx * dx + dy * dy <= radius * radius;
15    }
16}