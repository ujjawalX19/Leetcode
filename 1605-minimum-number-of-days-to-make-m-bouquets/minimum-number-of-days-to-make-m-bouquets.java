class Solution {

    // Helper function to check if we can make m bouquets in 'day' days
    public boolean canMake(int[] bloomDay, int day, int m, int k) {

        int count = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        // Count bouquets from the last consecutive flowers
        bouquets += count / k;

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        // Not enough flowers
        if ((long) m * k > n)
            return -1;

        // Find minimum and maximum bloom day
        int low = bloomDay[0];
        int high = bloomDay[0];

        for (int i = 1; i < n; i++) {
            if (bloomDay[i] < low)
                low = bloomDay[i];

            if (bloomDay[i] > high)
                high = bloomDay[i];
        }

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1;   // Try smaller day
            } else {
                low = mid + 1;    // Need more days
            }
        }

        return low;
    }
}