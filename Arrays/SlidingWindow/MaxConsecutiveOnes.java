/*485. Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
      int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 1) {

                // Current window contains consecutive 1s
                int length = right - left + 1;

                maxLength = Math.max(maxLength, length);

            } else {

                // 0 breaks the consecutive sequence
                left = right + 1;
            }
        }

        return maxLength;
    }
}