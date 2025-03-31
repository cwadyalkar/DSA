class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 1;

        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                String node = queue.poll();

                if (node.equals(endWord)) {
                    return level;
                }

                List<String> neighbours = getNeighbours(node, set);
                for (String word : neighbours) {
                    if (set.contains(word)) {
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public List<String> getNeighbours(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char originalChar = wordArray[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == originalChar)
                    continue;

                wordArray[i] = ch;
                String newWord = new String(wordArray);

                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
            wordArray[i] = originalChar;
        }
        return neighbours;
    }
}