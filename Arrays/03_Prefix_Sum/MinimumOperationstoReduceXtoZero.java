/*1658. Minimum Operations to Reduce X to Zero
Medium
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109 */
class Solution {
    public int minOperations(int[] nums, int x) {
        long totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Sum of subarray that we want to keep
        long target = totalSum - x;

        // x is greater than total sum
        if (target < 0) {
            return -1;
        }

        // We need to keep nothing,
        // so remove the entire array
        if (target == 0) {
            return nums.length;
        }

        HashMap<Long, Integer> map = new HashMap<>();

        // Prefix sum 0 before the array starts
        map.put(0L, -1);

        long prefixSum = 0;
        int maxLength = -1;

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            long requiredPrefix = prefixSum - target;

            if (map.containsKey(requiredPrefix)) {

                int previousIndex = map.get(requiredPrefix);

                int length = i - previousIndex;

                maxLength = Math.max(maxLength, length);
            }

            // Store only first occurrence
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }
}