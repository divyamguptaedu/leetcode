class ProductOfNumbers {
    List<Integer> list;
    int prev;
    public ProductOfNumbers() {
        list = new ArrayList();
        list.add(1);
        prev = 1;
    }

    public void add(int num) {
        //if element is > 0 create next element in a prefix product list. Update prev to be this
        //element
        if (num > 0) {
            prev*=num;
            list.add(prev);
        }
        //if this is 0  we need to reinit the structure
        else {
            list = new ArrayList();
            list.add(1);
            prev = 1;
        }
    }

    public int getProduct(int k) {
        int N = list.size();
        //in case there are not enough elements by the problem definition it can only happen if
        //we have met 0 before. In this case return 0. In all other cases we get the product from
        //division due to prefix product property. Note that list always has n + 1 elements due to 
        //initial 1, we need it to avoid outofbounds checks for edge cases
        return (k < N) ? prev / list.get(N - 1 - k) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */