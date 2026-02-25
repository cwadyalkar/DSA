class Solution {
    class Temp{
        int temperature;
        int index;

        Temp(int temperature,int index){
            this.temperature = temperature;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temp> stack = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];

        for(int i = n - 1;i >= 0;i--){
            while(!stack.isEmpty() && stack.peek().temperature <= temperatures[i]){
                stack.pop();
            }
    
            ans[i] = stack.isEmpty() ? 0 : stack.peek().index - i; 
            stack.push(new Temp(temperatures[i],i));
            
        }

        return ans;
    }
}