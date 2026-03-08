class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for(int weight : weights){
            start = Math.max(start,weight);
            end = end + weight;
        }

        int capacity = -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(checkCapacity(weights, days, mid)){
                capacity = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return capacity;
    }

    public boolean checkCapacity(int weights[],int days,int mid){
        int minDays = 1;
        int capacity = 0;
        for(int i = 0;i < weights.length;i++){
            if(capacity + weights[i] <= mid){
                capacity = capacity + weights[i];
            }else{
                minDays++;
                capacity = weights[i];

                if(minDays > days){
                    return false;
                }
            }
        }
        return true;
    }
}