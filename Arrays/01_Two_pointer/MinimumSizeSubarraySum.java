class Solution {
    public int minSubArrayLen(int target, int[] nums) {
         int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Add current element to the window
            sum += nums[right];

            // If sum is >= target, try to shrink the window
            while (sum >= target) {

                int length = right - left + 1;

                minLength = Math.min(minLength, length);

                // Remove leftmost element
                sum -= nums[left];

                // Move left pointer
                left++;
            }
        }

        // If no valid subarray was found
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }

        return minLength;
    }
}