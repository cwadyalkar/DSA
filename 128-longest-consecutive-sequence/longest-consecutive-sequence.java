class Solution {
 public  int longestConsecutive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       int maxCount = 0;
       for(int num : nums){
           set.add(num);
       }
                  System.out.println("Hashset--->"+set);

       for(int num : set){
           System.out.println("for num--->"+num);
           if(!set.contains(num-1)){
              int curr = num;
               int len = 1;
                          System.out.println("curr--->"+curr);

               
               while(set.contains(curr+1)){
                   curr++;
                   len++;
               }
               maxCount = Math.max(maxCount,len);
           }
       }
                  System.out.println("maxCount--->"+maxCount);

       return maxCount;
    }
}