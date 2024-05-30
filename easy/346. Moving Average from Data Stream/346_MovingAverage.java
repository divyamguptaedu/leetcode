//I implemented a MovingAverage class to calculate the moving average of a stream of integers with a fixed window size. 
//I used an array to store the values in the current window and kept track of the sum of these values. 
//Each new value replaced the oldest value in the window, and I updated the sum accordingly. 
//This allowed me to compute the moving average efficiently by dividing the sum by the number of elements in the window.

//Time: O(1)
//Space: O(n)

class MovingAverage {
    private int[] storage; // Array to store the values in the current window
    private int n;         // Number of elements in the window
    private int insert;    // Index to insert the next value
    private long sum;      // Sum of the values in the window

    public MovingAverage(int size) {
        storage = new int[size]; // Initialize the storage array with the given size
        insert = 0;              // Start the insert index at 0
        sum = 0;                 // Initialize the sum to 0
    }

    public double next(int val) {
        if (n < storage.length) {
            n++; // Increase the number of elements in the window until it reaches the storage size
        }
        sum -= storage[insert]; // Subtract the value being replaced from the sum
        sum += val;             // Add the new value to the sum
        storage[insert] = val;  // Insert the new value into the storage array
        insert = (insert + 1) % storage.length; // Move the insert index, wrapping around if necessary
        return (double) sum / n; // Return the moving average
    }
}