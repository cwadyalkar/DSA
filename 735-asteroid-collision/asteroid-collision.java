class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean isAlive = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop();
                    isAlive = false;
                    break;
                } else {
                    isAlive = false;
                    break;
                }
            }
            if (isAlive) {
                stack.push(asteroid);
            }
        }
        int result[] = new int[stack.size()];
        for(int i = result.length-1;i>=0;i--){
                result[i] = stack.pop();
        }


        return result;

    }
}