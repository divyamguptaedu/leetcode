//I sorted the array of people by height in descending order, 
//and for people with the same height, I sorted by the number of people in front in 
//ascending order. This ensured that when inserting each person into the queue,
//their position was determined by the number of people already in the queue who
//are taller or of the same height. By inserting each person at their specified position, 
//the queue was reconstructed correctly.

//Input:  [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//Sorted: [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
//Result: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

//Time: nlogn, inserting into linked list in worst case can take upto n^2 time.
//Space: n
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people by height in descending order
        // For people with the same height, sort by the number of people in front (ascending order)
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                // If heights are equal, compare the number of people in front (k-values)
                if (person1[0] == person2[0]) {
                    return person1[1] - person2[1];
                }
                // Otherwise, sort by height in descending order
                return person2[0] - person1[0];
            }
        });

        // List to store the reconstructed queue
        List<int[]> queue = new LinkedList<>();
        
        // Insert each person into the queue at the index specified by their k-value
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        // Convert the list back to an array and return
        return queue.toArray(new int[people.length][2]);
    }
}