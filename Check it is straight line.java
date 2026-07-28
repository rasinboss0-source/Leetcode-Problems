class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int dx = coordinates[1][0] - x0;
        int dy = coordinates[1][1] - y0;
        
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (dx * (y - y0) - dy * (x - x0) != 0) {
                return false;
            }
        }
        return true;
    }
}
