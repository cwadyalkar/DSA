class Solution {
     public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            System.out.println("num--->"+num);

            if (map.containsKey(num)) {
                System.out.println("map num--->"+map.get(num));
                System.out.println("map i--->"+i);
         System.out.println("map abs--->"+Math.abs(map.get(num)-i));

                if(Math.abs(map.get(num)-i) <= k){
       
                    return true;
                }else{
                    map.put(num,i);
                }
            }
            else{
                map.put(num,i);
            }

        }
        return false;
    }
}