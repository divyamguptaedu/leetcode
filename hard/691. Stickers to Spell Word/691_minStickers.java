class Solution {
    public int minStickers(String[] stickers, String target) {
        List<Map<Character, Integer>> stickersCount = new ArrayList<>();
        for (String sticker: stickers) {
            Map<Character, Integer> stickerCount = new HashMap<>();
            for (int i = 0; i < sticker.length(); i++) {
                char c = sticker.charAt(i);
                stickerCount.put(c, stickerCount.getOrDefault(c, 0) + 1);
            }
            stickersCount.add(stickerCount);
        }
        Map<String, Integer> cache = new HashMap<>();
        Map<Character, Integer> charsCount = new HashMap<>();
        int result = minStickers(target, stickersCount, charsCount, cache);
        return result != Integer.MAX_VALUE ? result : -1;
    }

    private int minStickers(String target,
                            List<Map<Character, Integer>> stickersCount,
                            Map<Character, Integer> currStickerCount,
                            Map<String, Integer> cache) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        int result = currStickerCount.isEmpty() ? 0 : 1;
        StringBuilder remainingChars = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            Integer charCount = currStickerCount.get(c);
            if(charCount != null && charCount > 0){
                currStickerCount.put(c, charCount - 1);
            } else remainingChars.append(c);
        }

        if (!remainingChars.isEmpty()) {
            int used = Integer.MAX_VALUE;
            for (Map<Character, Integer> stickerCount: stickersCount) {
                if (!stickerCount.containsKey(remainingChars.charAt(0))) {
                    continue;
                }
                used = Math.min(used, minStickers(remainingChars.toString(), stickersCount, new HashMap<>(stickerCount), cache));
            }
            cache.put(remainingChars.toString(), used);
            result = used == Integer.MAX_VALUE ? used : result + used;

        }
        return result;
    }
}