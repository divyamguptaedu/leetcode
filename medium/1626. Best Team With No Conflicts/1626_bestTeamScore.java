class Solution {
    class Player implements Comparable<Player> {
        int age;
        int score;
        Player (int age, int score) {
            this.age = age;
            this.score = score;
        }
        public int compareTo(Player next) {
            if (this.age == next.age) {
                return this.score - next.score;
            }
            return this.age - next.age;
        }
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int best = 0;
        int len = scores.length;
        Player[] players = new Player[len];
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            Player p0 = new Player(ages[i], scores[i]);
            players[i] = p0;
        }
        Arrays.sort(players);
        for (int i = 0; i < len; i++) {
            dp[i] = players[i].score;
            for (int j = 0; j < i; j++) {
                if(players[j].score <= players[i].score )
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}