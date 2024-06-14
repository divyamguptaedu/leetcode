//To predict the winning party in the Dota2 senate, 
//I maintained counts of Radiant ('R') and Dire ('D') 
//senators and tracked floating bans for each party. 
//I used a queue to process senators in a round-based manner. 
//For each senator, I checked if they were banned; if so, 
//I reduced their count and floating ban. If not, 
//I issued a floating ban on the opposing party and re-queued the senator. 
//This continued until all senators of one party were banned. 
//The party with remaining senators was declared the winner.

//Time: n
//Space: n
class Solution {
    public String predictPartyVictory(String senate) {

        // Number of Senators of each party
        int rCount = 0, dCount = 0;

        // Floating Ban Count
        int dFloatingBan = 0, rFloatingBan = 0;

        // Queue of Senators
        Queue<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            q.add(c);
            if (c == 'R')
                rCount++;
            else
                dCount++;
        }

        // While any party has eligible Senators
        while (rCount > 0 && dCount > 0) {

            // Pop the senator with turn
            char curr = q.poll();

            // If eligible, float the ban on the other party, enqueue again.
            // If not, decrement the floating ban and count of the party.
            if (curr == 'D') {
                if (dFloatingBan > 0) {
                    dFloatingBan--;
                    dCount--;
                } else {
                    rFloatingBan++;
                    q.add('D');
                }
            } else {
                if (rFloatingBan > 0) {
                    rFloatingBan--;
                    rCount--;
                } else {
                    dFloatingBan++;
                    q.add('R');
                }
            }
        }

        // Return the party with eligible Senators
        return rCount > 0 ? "Radiant" : "Dire";
    }
}