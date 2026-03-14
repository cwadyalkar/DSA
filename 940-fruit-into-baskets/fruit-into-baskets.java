class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int maxFruit = 0;

        for(int j = 0;j < fruits.length;j++){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);

            while(map.size() > 2){
                map.put(fruits[i],map.getOrDefault(fruits[i],0)-1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }

            maxFruit = Math.max(maxFruit,j - i + 1);
        }
        return maxFruit;
    }
}