class Solution {
    public int minStickers(String[] stickers, String target) {
        String sortedTarget = sortString(target);
        String[] sortedStickers = new String[stickers.length];

        // O(N) * MLogM where M is the Max length of stickers
        for (int i = 0; i < sortedStickers.length; i++) {
            sortedStickers[i] = sortString(stickers[i]);
        }

        Queue<String> queue = new LinkedList<>();
        int steps = 1;
        Set<String> visited = new HashSet<>();

        queue.offer(sortedTarget);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentStr = queue.poll();
                // Match with each sticker and filter the target
                for (int j = 0; j < sortedStickers.length; j++) {
                    String remStr = filterByMatching(sortedStickers[j], currentStr);
                    if (remStr.isEmpty()) {
                        return steps;
                    }
                    if (!visited.contains(remStr)) {
                        visited.add(remStr);
                        queue.offer(remStr);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    //O(inputString * sticker)
    private String filterByMatching(String sticker, String inputString) {
        StringBuilder filterString = new StringBuilder();
        int index = 0;

        // O(inputString * sticker)
        for (char inputCh : inputString.toCharArray()) {
            boolean found = false;
            while (index < sticker.length() && sticker.charAt(index) <= inputCh) {
                if (sticker.charAt(index++) == inputCh) {
                    found = true;
                    break;
                }
            }
            if (!found)
                filterString.append(inputCh);
        }
        return filterString.toString();
    }


    //O(nlogn)
    private String sortString(String input) {
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        return new String(inputArr);
    }
}