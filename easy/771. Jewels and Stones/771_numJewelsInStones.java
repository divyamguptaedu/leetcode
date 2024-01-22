class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        builder.append(jewels);

        for (char c : stones.toCharArray())
        {
            if (builder.toString().contains(String.valueOf(c))) {
                count++;
            }
        }

        return count;
    }
}