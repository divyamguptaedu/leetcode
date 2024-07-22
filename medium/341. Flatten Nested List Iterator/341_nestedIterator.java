//Used a simple approach to first compute the flattened list using recursion, then just used a position pointer to have other two functions in O(1)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> flattennedList;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattennedList = new ArrayList<>();
        flattenList(nestedList);
        index = 0;
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                this.flattennedList.add(n.getInteger());
            } else {
                flattenList(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return this.flattennedList.get(index++);
        } else {
            return -1;
        }
    }

    @Override
    public boolean hasNext() {
        return index < this.flattennedList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */