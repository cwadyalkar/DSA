class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if(pattern.length() != words.length) return false;
    

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {

            char ch1 = pattern.charAt(i);
            String word = words[i];
        
            if(charToWord.containsKey(ch1)){
                if(!charToWord.get(ch1).equals(word)){
                    return false;
                }
            }else{
                charToWord.put(ch1,word);
            }

          if(wordToChar.containsKey(word)){
                if(!wordToChar.get(word).equals(ch1)){
                    return false;
                }
            }else{
                wordToChar.put(word,ch1);
            }

        }
        return true;

    }
}