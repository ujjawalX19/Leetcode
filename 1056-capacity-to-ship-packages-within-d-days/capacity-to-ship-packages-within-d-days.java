class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Find max element and sum
        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean canShip(int[] weights, int capacity, int days) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int i = 0; i < weights.length; i++) {

            if (currentWeight + weights[i] <= capacity) {
                currentWeight += weights[i];
            } else {
                requiredDays++;
                currentWeight = weights[i];
            }
        }

        return requiredDays <= days;
    }
}