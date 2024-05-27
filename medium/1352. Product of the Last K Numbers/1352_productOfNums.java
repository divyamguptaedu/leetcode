
//To solve the problem of calculating the product of the last k numbers in a stream, 
//I maintained a list of prefix products. On adding a new number, if it's positive, 
//I multiplied it with the last prefix product and appended the result. 
//If the number was zero, I reset the list to start fresh, 
//ensuring any subsequent product calculations involving the zero return zero. 
//To get the product of the last k numbers, 
//I divided the last prefix product by the prefix product k positions before it, 
//unless k exceeds the list size due to a reset, in which case I returned zero.

//Time: O(1) for both add and getProduct
//Space: O(n)
class ProductOfNumbers {
    // List to store the prefix products
    List<Integer> list;
    // Variable to store the last product value
    int prev;

    // Constructor to initialize the list with a 1 and set the initial product value to 1
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
        prev = 1;
    }

    // Method to add a number to the stream
    public void add(int num) {
        if (num > 0) {
            // If the number is positive, multiply it with the last product and add to the list
            prev *= num;
            list.add(prev);
        } else {
            // If the number is zero, reset the list and the last product value
            list = new ArrayList<>();
            list.add(1);
            prev = 1;
        }
    }

    // Method to get the product of the last k numbers
    public int getProduct(int k) {
        int N = list.size();
        // If k is within the list size, return the product by dividing the last product by the product k positions ago
        // Otherwise, return 0 since a reset must have occurred
        return (k < N) ? prev / list.get(N - 1 - k) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
