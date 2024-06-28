//I approached the problem by first identifying the maximum attack value. 
//Then, I created an array to store the maximum defense for each attack value. 
//I filled this array by iterating through the properties and updating the maximum defense for each attack. 
//I then updated this array to hold the maximum defense for attacks greater than or equal to the current value. 
//Finally, I counted the weak characters by checking if there was a greater defense for properties with 
//higher attack values.
//Time: m+n
//Spae: m
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int maxAttack = 0;
        // Find the maximum atack value
        for (int[] property : properties) {
            int attack = property[0];
            maxAttack = Math.max(maxAttack, attack);
        }

        int maxDefense[] = new int[maxAttack + 2];
        // Store the maximum defense for an attack value
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];

            maxDefense[attack] = Math.max(maxDefense[attack], defense);
        }

        // Store the maximum defense for attack greater than or equal to a value
        for (int i = maxAttack - 1; i >= 0; i--) {
            maxDefense[i] = Math.max(maxDefense[i], maxDefense[i + 1]);
        }

        int weakCharacters = 0;
        for (int[] property : properties) {
            int attack = property[0];
            int defense = property[1];

            // If their is a greater defense for properties with greater attack
            if (defense < maxDefense[attack + 1]) {
                weakCharacters++;
            }
        }

        return weakCharacters;
    }
}