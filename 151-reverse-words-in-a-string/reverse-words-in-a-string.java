class Solution {
    public String reverseWords(String s) {
       String str[] = s.trim().split("\\s+");
        int i = 0;
        int j = str.length - 1;
        while(i < j){
            swap(str,i,j);
            i++;
            j--;
        }
       return String.join(" ", str) ; 
    }

    public void swap(String str[],int i,int j){
        String word = str[i];
        str[i] = str[j];
        str[j] = word;
    }
}