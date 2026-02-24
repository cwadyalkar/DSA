class Solution {
    public int getMax(int piles[]) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }

    public boolean canEatAll(int piles[], int mid, int h) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours = totalHours + (pile + mid - 1) / mid;
        }
        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getMax(piles);
          int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canEatAll(piles,mid,h)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

}