/*438. Find All Anagrams in a String
Medium
Topics
premium lock icon
Companies
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters. */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result= new ArrayList<>();

        if(p.length()>s.length()){
            return result;
        }
        int[] pCount= new int[26];
        int[] windowCount= new int[26];

        //count characters of p
        for(char c: p.toCharArray()){
            pCount[c-'a']++;
        }
        int left=0;
        //Add current character to window
        for(int right=0;right<s.length();right++){
            windowCount[s.charAt(right)-'a']++;
            
            //keep window size equal to p.length()
            if(right - left+1>p.length()){
                windowCount[s.charAt(left)-'a']--;
                left++;
            }
            //check if current window is an anagram
            if(right-left+1==p.length()){
                if(Arrays.equals(pCount,windowCount)){
                    result.add(left);
                }
            }
        }
        return result;

    }
}