class Solution {
    public int maxSubArray(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int left = 0;

        for (int right = 0; right < arr.length; right++) {

            // Add current element to window
            windowSum += arr[right];

            // When window size becomes k
            if (right - left + 1 == k) {

                // Update maximum sum
                maxSum = Math.max(maxSum, windowSum);

                // Remove left element
                windowSum -= arr[left];
                left++;
            }
        }

        return maxSum;
    }
}