// Q2: find the Kth missing item in sequence given longest increasing sequence, ignoring the items before starting element
// [2,3,5,8,10,50,100], k=3 => 7

public class KthMissingInSequence {
    public static int findKthMissing(int[] sequence, int k) {
        if (sequence == null || sequence.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        int countMissing = 0;
        int prev = sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            int current = sequence[i];
            int missingCount = current - prev - 1;
            
            if (countMissing + missingCount >= k) {
                // The Kth missing number is between prev and current
                return prev + (k - countMissing);
            }
            
            countMissing += missingCount;
            prev = current;
        }
        
        // If we reach here, the Kth missing number is beyond the last element
        return sequence[sequence.length - 1] + (k - countMissing);
    }

    public static void main(String[] args) {
        int[] sequence = {2, 3, 5, 8, 10, 50, 100};
        int k = 3;

        int result = findKthMissing(sequence, k);
        System.out.println("Kth missing item for k=" + k + ": " + result);
    }
}
