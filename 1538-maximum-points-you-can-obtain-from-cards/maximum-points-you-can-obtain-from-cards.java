class Solution {
    public int maxScore(int[] cardsPoints, int k) {
        int n = cardsPoints.length;
        if(k == n){
            int total = 0;
            for(int num : cardsPoints) total = total + num;
            return total;
        }
        int leftSum = 0;
        for(int i = 0;i < k ;i++){
            leftSum = leftSum + cardsPoints[i];
        }
        int sum = leftSum;
        int leftIndex = k - 1;
        int rightIndex = n-1;
        int rightSum = 0;
        for(int i=0;i<k;i++){
            leftSum = leftSum - cardsPoints[leftIndex];
            leftIndex--;
            rightSum = rightSum + cardsPoints[rightIndex];
            rightIndex--;

            sum = Math.max(sum,leftSum+rightSum);
        }
        return sum;
    }
}