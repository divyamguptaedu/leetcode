//To split the message efficiently, 
//I initialize the count of 'a' characters to 0 and the part count 'b' to 0. 
//I then calculate the total length of the message. 
//While the condition for constructing parts is satisfied, 
//increment 'b' and update the count of 'a'. 
//I ensure the length of each part is less than or equal to the limit. 
//If it's possible to create parts, I iterate through the message, 
//creating each part with the appropriate suffix '<a/b>'. 
//Finally, I return the array of parts. 
//If it's impossible, I return an empty array.

//Time: O(n)
//Space: O(n)
class Solution {
    public String[] splitMessage(String message, int limit) {
        int sumOfA = 0, b = 0;
        int messageTotalLength = message.length();
        while (digitLength(b) * 2 + 3 < limit &&
                sumOfA + messageTotalLength + (3 + digitLength(b)) * b > limit * b) {
            b++;
            sumOfA += digitLength(b);
        }
        if (3 + digitLength(b) * 2 < limit) {
            String[] result = new String[b];
            int pos = 0;
            for (int i = 0; i < b; i++) {
                int messageLength = limit - (3 + digitLength(b) + digitLength(i + 1));
                StringBuilder sb = new StringBuilder();
                sb.append(message.substring(pos, Math.min(pos + messageLength, messageTotalLength)));
                sb.append("<").append(i + 1).append("/").append(b).append(">");
                result[i] = sb.toString();
                pos += messageLength;
            }
            return result;
        }
        return new String[0];
    }

    public int digitLength(int num) {
        return String.valueOf(num).length();
    }

}