// You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
// The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
// Return the sum of each integer in nestedList multiplied by its depth.

import java.util.*;

// Assume NestedInteger class is defined somewhere, with methods:
// interface NestedInteger {
//     boolean isInteger();
//     int getInteger();
//     List<NestedInteger> getList();
// }

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sum(nestedList, 1);
    }

    private int sum(List<NestedInteger> nestedList, int depth) {
        int s = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                s += ni.getInteger() * depth;
            } else {
                s += sum(ni.getList(), depth + 1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example usage and testing
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedIntegerImpl(1));
        List<NestedInteger> sublist1 = new ArrayList<>();
        sublist1.add(new NestedIntegerImpl(2));
        sublist1.add(new NestedIntegerImpl(2));
        nestedList.add(new NestedIntegerImpl(sublist1));
        List<NestedInteger> sublist2 = new ArrayList<>();
        sublist2.add(new NestedIntegerImpl(new ArrayList<>()));
        sublist2.add(new NestedIntegerImpl(2));
        nestedList.add(new NestedIntegerImpl(sublist2));
        nestedList.add(new NestedIntegerImpl(1));

        int result = solution.depthSum(nestedList);
        System.out.println("Sum multiplied by depth: " + result);
    }
}

// Dummy implementation of NestedInteger for testing purpose
class NestedIntegerImpl implements NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    public NestedIntegerImpl(int value) {
        this.value = value;
        this.list = null;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.value = null;
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return value != null;
    }

    @Override
    public int getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

// Dummy interface for NestedInteger
interface NestedInteger {
    boolean isInteger();
    int getInteger();
    List<NestedInteger> getList();
}
