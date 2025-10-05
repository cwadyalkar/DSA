class Solution {
      public  int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int startIndex = 0;
        int gasLeft = 0;
        for (int i = 0; i < gas.length; i++) {

            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
        }
            System.out.println(totalGas);
            System.out.println(totalCost);
            if (totalGas < totalCost) {
                return -1;
            }
        for (int i = 0; i < gas.length; i++) {
            gasLeft = gas[i] - cost[i] + gasLeft;
            if (gasLeft < 0) {
                startIndex = i + 1;
                gasLeft = 0;
            }
        }
        System.out.println(startIndex);
        return startIndex;

    }
}