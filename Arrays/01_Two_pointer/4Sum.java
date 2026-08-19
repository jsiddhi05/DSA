/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]] */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Fix the first element
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Fix the second element
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Two pointers
                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[k]
                             + nums[l];

                    if (sum == target) {

                        // Add quadruplet
                        result.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[k],
                            nums[l]
                        ));

                        // Skip duplicate k
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }

                        // Skip duplicate l
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }

                        // Move both pointers
                        k++;
                        l--;

                    } else if (sum < target) {

                        // Need a bigger sum
                        k++;

                    } else {

                        // Need a smaller sum
                        l--;
                    }
                }
            }
        }

        return result;
    }
}