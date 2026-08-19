/*Algorithm
In this approach, we will first sort the array and will try to choose the numbers in a greedy way.

We will keep a left pointer at the first index and a right pointer at the last index. Now until left < right, we will check the sum of arr[left] and arr[right]. Now if the sum < target, we need bigger numbers and so we will increment the left pointer. But if sum > target, we need to consider lesser numbers and so we will decrement the right pointer.

If sum == target we will return either “YES” or the indices as per the question. But if the left crosses the right pointer, we will return “NO” or {-1, -1}.
We will sort the given array first.
Now, we will take two pointers i.e. left, which points to the first index, and right, which points to the last index.
Now using a loop we will check the sum of arr[left] and arr[right] until left < right.
If arr[left] + arr[right] > sum, we will decrement the right pointer.
If arr[left] + arr[right] < sum, we will increment the left pointer.
If arr[left] + arr[right] == sum, we will return the result.
Finally, if no results are found we will return “NO” or {-1, -1}.
Input: N = 5, arr[] = {2,6,5,8,11}, target = 14
Output : YES
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for first variant for second variant output will be : [1,3].

Input: N = 5, arr[] = {2,6,5,8,11}, target = 15
Output : NO.
Explanation: There exist no such two numbers whose sum is equal to the target.  */
import java.util.Arrays;

class Solution {
    // Variant 1: Check if two numbers sum to target using two-pointer approach
    public String twoSumExists(int[] arr, int target) {
        int n = arr.length;
        
        // Create an array of pairs [value, original_index]
        int[][] numsWithIndex = new int[n][2];
        
        // Store each element with its original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i]; // value
            numsWithIndex[i][1] = i;      // original index
        }
        
        // Sort the array based on the value, not index
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize two pointers: one at start, one at end
        int left = 0, right = n - 1;
        
        // Run loop until pointers cross
        while (left < right) {
            // Calculate the sum of values at pointers
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            
            if (sum == target) {
                // Found the pair, return "YES"
                return "YES";
            } else if (sum < target) {
                // Sum is less than target, so move left pointer right to increase sum
                left++;
            } else {
                // Sum is greater than target, so move right pointer left to decrease sum
                right--;
            }
        }
        
        // If loop ends without returning, no pair found
        return "NO";
    }

    // Variant 2: Return indices of two numbers that sum to target
    public int[] twoSumIndices(int[] arr, int target) {
        int n = arr.length;
        int[][] numsWithIndex = new int[n][2];
        
        // Store element with original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }
        
        // Sort by the value to apply two-pointer
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                // Return original indices of the two numbers found
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }
        
        // No pair found
        return new int[] {-1, -1};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        System.out.println(sol.twoSumExists(arr, target)); // Output: YES
        int[] res = sol.twoSumIndices(arr, target);
        System.out.println("[" + res[0] + ", " + res[1] + "]"); // Output: [1, 3]
    }
}