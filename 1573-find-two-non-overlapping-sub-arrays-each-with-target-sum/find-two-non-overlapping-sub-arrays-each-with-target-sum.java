class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // minLen[i] stores the minimum length of a valid subarray ending at or before index i
        int[] minLen = new int[n];
        java.util.Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int sum = 0, left = 0;
        int result = Integer.MAX_VALUE;
        int currentMin = Integer.MAX_VALUE;

        // Single pass sliding window
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            // Shrink window from the left if sum exceeds target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            // If we found a valid subarray summing to target
            if (sum == target) {
                int len = right - left + 1;
                
                // Check if there is a valid non-overlapping subarray to the left
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minLen[left - 1]);
                }
                
                // Update the shortest valid subarray length found so far
                currentMin = Math.min(currentMin, len);
            }
            
            // Save the best minimum length up to the current index
            minLen[right] = currentMin;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}