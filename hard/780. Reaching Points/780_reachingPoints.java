"
Performance:
Runtime: 1 ms, faster than 44.03% of Java online submissions for Reaching Points.
Memory Usage: 41.2 MB, less than 35.19% of Java online submissions for Reaching Points.
"

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && (ty - sy) % sx == 0) {
            return true;
        }
        if (sy == ty && (tx - sx) % sy == 0) {
            return true;
        }
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}