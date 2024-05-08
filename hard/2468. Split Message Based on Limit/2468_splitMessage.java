//To solve this question, the main thing we need is how many parts do we create? To find that perfect value, we can use binary search.
//The min part val can be 1, max can be the length of the message. So, from 1 to message.len, we can do a binary search and check if the mid value
//is good to be used. How do we check if it is good? We will need to define a function for that. That function will check for each i/#parts, 
//if we consider char spaces used (3 + len(i) + len(parts)), subtract it from the limit, get how many spaces we have left, and if it can fit the whole message.
//Once we have our #parts number, the job left is to create the result array, which will involve iterating over the message string and adding the suffix
//using the current part and total parts value.

//Time: O(nlogn)
//Space: O(n)

class Solution {
    public String[] splitMessage(String message, int limit) {
        int low = 1;
        int high = message.length();
        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            int value = checkValidity(message, limit, mid);
            if (value == 0) {
                result = Math.min(result, mid);
                high = mid - 1;
                low = 1;
            } else if (value == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (result == Integer.MAX_VALUE) {
            return new String[0];
        } else {
            return getFormattedStrings(message, limit, result);
        }
    }

    private int checkValidity(String message, int limit, int k) {
        int idx = 0;
        for (int i = 1; i <= k; i++) {
            if (idx >= message.length()) {
                return -1;
            }
            String format = "<" + i + "/" + k + ">";
            int left = limit - format.length();
            if (left <= 0) {
                return -1; //not possible
            }
            idx += left;
        }

        if (idx < message.length()) {
            return 1; //need to go higher
        }
        return 0; //can go lower
    }

    private String[] getFormattedStrings(String message, int limit, int k) {
        String[] result = new String[k];
        int idx = 0;
        for (int i = 1; i <= k; i++) {
            String format = "<" + i + "/" + k + ">";
            int diff = limit - format.length();
            if (idx + diff > message.length()) {
                result[i - 1] = message.substring(idx) + format; //last part
            } else {
                result[i - 1] = message.substring(idx, idx + diff) + format;
            }
            idx += diff;
        }
        return result;
    }
}