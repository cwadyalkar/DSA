import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, Boolean> map = new HashMap<>();

        for (String str : wordList) {
            map.put(str, false);
        }

        if (!map.containsKey(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        map.put(beginWord, true);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return step;

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;

                        arr[j] = ch;
                        String newStr = new String(arr);

                        if (map.containsKey(newStr) && !map.get(newStr)) {
                            queue.offer(newStr);
                            map.put(newStr, true);
                        }
                    }

                    arr[j] = original;
                }
            }

            step++;
        }

        return 0; 
    }
}