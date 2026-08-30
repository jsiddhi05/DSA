/*567. Permutation in String
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters. */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
     if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int windowSize = s1.length();

        // First window
        for (int i = 0; i < windowSize; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Sliding window
        for (int right = windowSize; right < s2.length(); right++) {

            // Add new character
            count2[s2.charAt(right) - 'a']++;

            // Remove old character
            int left = right - windowSize;
            count2[s2.charAt(left) - 'a']--;

            // Check if current window is a permutation
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        // Check the first window
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        return false;
    }
}