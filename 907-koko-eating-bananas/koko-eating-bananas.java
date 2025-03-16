class Solution {
    public int getMax(int piles[]) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }

    public boolean canEatAll(int piles[], int h, int mid) {
        int hours = 0;
        for (int pile : piles) {
            hours = hours + (pile + mid - 1) / mid;
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}