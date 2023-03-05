class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String num) {
        if (backtrack(num, 0)) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean backtrack(String num, int index) {
        if (index == num.length()) {
            return result.size() > 2;
        }
        int number = 0;
        for (int i = index; i < num.length(); i++) {
            number = (number * 10) + (num.charAt(i) - '0');
            if (number < 0) {
                return false;
            }
            if (result.size() < 2 || result.get(result.size() - 1) + result.get(result.size() - 2) == number) {
                result.add(number);
                if (backtrack(num, i + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
            if (i == index && num.charAt(i) == '0') {
                return false;
            }
        }
        return false;
    }
}