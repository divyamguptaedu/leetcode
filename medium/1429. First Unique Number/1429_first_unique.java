"
Peformance:
Runtime: 122 ms, faster than 40.28% of Java online submissions for First Unique Number.
Memory Usage: 96.2 MB, less than 22.12% of Java online submissions for First Unique Number.
"

class FirstUnique {
    
    Set<Integer> unique = new LinkedHashSet<>();
    Set<Integer> all = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int n:nums){
            if (!all.contains(n)) {
                all.add(n);
                unique.add(n);
            } else {
                unique.remove(n);
            }
        }
    }
    
    public int showFirstUnique() {
        if (unique.isEmpty()) {
        	return -1;
        }
        return unique.iterator().next();
    }
    
    public void add(int value) {
        if (!all.contains(value)) {
            all.add(value);
            unique.add(value);
        } else {
            unique.remove(value);
        }
    }
}