class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            // put strings into char array
            char[] charArr = str.toCharArray();
            // sort them
            Arrays.sort(charArr);
            // convert char array into strings
            String sortedStr = new String(charArr);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
                            
            }
            map.get(sortedStr).add(str);

        }
        return new ArrayList<>(map.values());
        
    }
}