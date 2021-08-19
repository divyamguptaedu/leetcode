"
Performance: 
Runtime: 21 ms, faster than 44.46% of Java online submissions for Find the Celebrity.
Memory Usage: 39.2 MB, less than 85.41% of Java online submissions for Find the Celebrity.
"

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    private int people;
    
    public int findCelebrity(int n) {
        people = n;
        for (int i = 0; i < n; i++) {
            if (helper(i)) {
                return i;
            }
        }
        return -1;
    }
    
    private boolean helper(int i) {
        for (int j = 0; j < people; j++) {
            if (i == j) {
            continue;
            }
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}