class Solution {
    public List<Integer> findDuplicates(int[] numbers) {
        List<Integer> duplicates = new ArrayList<>();

        for (int num : numbers) {
            int index = Math.abs(num) - 1;

            // If the number at this index is already negative, it means the number has been seen before
            if (numbers[index] < 0) {
                duplicates.add(Math.abs(num));
            }
            // Mark the number at this index as seen by making it negative
            numbers[index] *= -1;
        }

        return duplicates;
    }
}

//I iterated through the array and used the absolute value of each element as an index. 
//I marked the element at this index as negative to signify that the number has been seen. 
//If I encountered a negative value at this index again, 
//it meant the number had already been seen, so I added it to the result list.
//Time: n
//Space: x, where x is the num of duplicates in nums
class Solution {
    public List<Integer> findDuplicates(int[] numbers) {
        List<Integer> duplicates = new ArrayList<>();

        for (int num : numbers) {
            int index = Math.abs(num) - 1;

            // If the number at this index is already negative, it means the number has been seen before
            if (numbers[index] < 0) {
                duplicates.add(Math.abs(num));
            }
            // Mark the number at this index as seen by making it negative
            numbers[index] *= -1;
        }

        return duplicates;
    }
}