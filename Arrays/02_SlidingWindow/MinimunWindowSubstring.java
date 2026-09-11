/*76. Minimum Window Substring
Hard
Topics
Companies
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The test cases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The whole string s is the minimum window substring.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since there is no such substring, we return the empty string "".


You can have at most 2 different types of fruits in your window.

We use:

left → start of window
right → end of window
HashMap → stores fruit type and its frequency
maxLength → longest valid window */

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128];

        // Store frequency of characters required from t
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            // If this character is required
            if (count[c] > 0) {
                required--;
            }

            count[c]--;
            right++;

            // Window contains all characters of t
            while (required == 0) {

                // Calculate current window length
                int length = right - left;

                // Update minimum window
                if (length < minLength) {
                    minLength = length;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                count[leftChar]++;

                // If count becomes positive,
                // we removed a required character
                if (count[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}