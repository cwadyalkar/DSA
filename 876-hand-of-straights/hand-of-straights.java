class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);

        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(map.keySet());
        while (!minHeap.isEmpty()) {
            int firstCard = minHeap.peek();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;
                if (!map.containsKey(currentCard) || map.get(currentCard) == 0) {
                    return false;
                }
                map.put(currentCard, map.get(currentCard) - 1);

                if (map.get(currentCard) == 0) {
                    map.remove(currentCard);
                    minHeap.remove(currentCard);
                }
            }

        }
        return true;
    }
}