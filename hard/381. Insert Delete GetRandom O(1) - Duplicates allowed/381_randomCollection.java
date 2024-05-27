class RandomizedCollection {
    ArrayList<Integer> list = new ArrayList<>();
    Map<Integer, HashSet<Integer>> locs = new HashMap<>();
    Random rand = new Random();
    int size = 0;

    public RandomizedCollection() {

    }

    public boolean insert(int val) {
        int id = list.size();
        list.add(val);

        boolean present = !locs.containsKey(val);

        HashSet<Integer> ll = locs.computeIfAbsent(val, kk -> new HashSet<>());
        ll.add(id);

        return present;
    }

    private int pollFirst(HashSet<Integer> set) {
        Integer first = set.iterator().next();
        set.remove(first);
        return first;
    }

    public boolean remove(int val) {
        if (locs.containsKey(val)) {
            HashSet<Integer> ll = locs.get(val);
            if (!ll.isEmpty()) {

                int id = pollFirst(ll);
                if (id < list.size() - 1) {
                    int oldId = list.size() - 1;
                    int lastVal = list.remove(oldId);
                    list.set(id, lastVal);

                    replaceLastFromMap(lastVal, oldId, id);
                } else {
                    list.remove(list.size() - 1);
                }

                if (ll.isEmpty()) {
                    locs.remove(val);
                }

                return true;
            }
        }
        return false;
    }

    private void replaceLastFromMap(int lastVal, int oldId, int newId) {
        HashSet<Integer> ll = locs.get(lastVal);
        ll.remove(oldId);
        ll.add(newId);
    }

    public int getRandom() {
        int r = rand.nextInt(list.size());
        return list.get(r);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */