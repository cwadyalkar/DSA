class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];
        for(int i= 0;i<numbers.length;i++){
            int twoSum = target - numbers[i];
            if(map.containsKey(twoSum)){
               return new int[]{map.get(twoSum),i+1} ;
            }
            map.put(numbers[i],i+1);
        }
        return new int[]{-1,-1};
    }
}