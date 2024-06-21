//I used a TreeMap to store and manage the ranges. 
//For adding a range, I checked for existing overlaps and merged ranges by updating the boundaries and 
//removing the overlapping entries. For querying, I checked if the starting point falls within an existing 
//range that covers the entire queried interval. 
//For removing, I adjusted existing ranges that intersect with the removal range and then removed the 
//entries that are fully within the removal range.

//Time: logn for all
//Space: n
class RangeModule {
    // TreeMap to store ranges with start as key and end as value
    TreeMap<Integer, Integer> ranges;

    public RangeModule() {
        ranges = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        // Find the existing range that might overlap with the new range start
        var lowerEntry = ranges.floorEntry(left);
        var higherEntry = ranges.floorEntry(right);

        // Adjust the new range boundaries if there are overlapping ranges
        if (lowerEntry != null && lowerEntry.getValue() >= left) {
            left = lowerEntry.getKey();
        }
        if (higherEntry != null && higherEntry.getValue() > right) {
            right = higherEntry.getValue();
        }

        // Remove all overlapping ranges within the new range boundaries
        ranges.subMap(left, right).clear();

        // Add the new merged range
        ranges.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        // Find the range that might contain the queried interval
        var lowerEntry = ranges.floorEntry(left);
        // Check if the found range completely covers the queried interval
        return lowerEntry != null && lowerEntry.getValue() >= right;
    }

    public void removeRange(int left, int right) {
        // Find the existing range that might overlap with the removal range start
        var lowerEntry = ranges.floorEntry(left);
        var higherEntry = ranges.floorEntry(right);

        // Adjust the range boundaries of overlapping ranges
        if (lowerEntry != null && lowerEntry.getValue() > left) {
            ranges.put(lowerEntry.getKey(), left);
        }
        if (higherEntry != null && higherEntry.getValue() > right) {
            ranges.put(right, higherEntry.getValue());
        }

        // Remove all ranges that fall within the removal range boundaries
        ranges.subMap(left, right).clear();
    }
}