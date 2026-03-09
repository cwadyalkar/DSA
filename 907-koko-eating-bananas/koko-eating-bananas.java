class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int pile : piles){
            end = Math.max(end,pile);
        }
        int canEatInHour = -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(canEatBanana(piles,h,mid)){
                canEatInHour = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return canEatInHour;
    }

    public boolean canEatBanana(int piles[],int h,int speed){
        int hour = 0;
        for(int pile : piles){
            hour = hour + (pile + speed - 1)/speed;
            
            if(hour > h){
                return false;
            }
        }

        return true;
    }
}