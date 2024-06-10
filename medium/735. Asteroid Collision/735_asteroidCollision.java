//I traverse the array of asteroids, simulating their collisions using a stack. 
//I compare each asteroid with the top of the stack, checking if they will collide. 
//If they do, the smaller one explodes. If both are of equal size, both explode. 
//If the stack's top asteroid is larger, it remains, and the current asteroid explodes. 
//If the current asteroid survives, I add it to the stack. 
//Finally, I construct the array of remaining asteroids by popping from the stack.

//Time: n
//Space: n
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean survive = true;
            // Check for collisions while iterating through asteroids
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                // If the top asteroid in the stack is smaller, it explodes
                // Pop it from the stack and continue checking with the next asteroid in the stack
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }
                // If both asteroids have the same size, both explode
                // Pop the asteroid from the stack; also, don't push the current asteroid
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }
                // If we reach here, the current asteroid will be destroyed
                // Hence, we shouldn't add it to the stack
                survive = false;
                break;
            }
            // Add the asteroid to the stack if it survives
            if (survive) {
                stack.push(asteroid);
            }
        }
        // Construct the array of remaining asteroids by popping from the stack
        int[] remainingAsteroids = new int[stack.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = stack.peek();
            stack.pop();
        }
        return remainingAsteroids;
    }
}