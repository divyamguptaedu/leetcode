// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
// Implement the MovingAverage class:
// MovingAverage(int size) Initializes the object with the size of the window size.
// double next(int val) Returns the moving average of the last size values of the stream.

import java.util.*;

class MovingAverage {
    int size;
    int sum;
    List<Integer> mem;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        mem = new ArrayList<>();
    }

    public double next(int val) {
        if (mem.size() == size) {
            sum -= mem.get(0);
            mem.remove(0);
        }
        sum += val;
        mem.add(val);
        return (double) sum / mem.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println("Next moving average: " + m.next(1)); // return 1.0
        System.out.println("Next moving average: " + m.next(10)); // return (1 + 10) / 2 = 5.5
        System.out.println("Next moving average: " + m.next(3)); // return (1 + 10 + 3) / 3 = 4.67
        System.out.println("Next moving average: " + m.next(5)); // return (10 + 3 + 5) / 3 = 6.0
    }
}
