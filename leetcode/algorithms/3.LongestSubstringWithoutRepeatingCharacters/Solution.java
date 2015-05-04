/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 **/

import java.util.ArrayList;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        int max = 0;
        int length = 0;
        ArrayList<Character> array = new ArrayList<Character>();
        for (int i = 0; i < str.length; i++) {
            if (array.contains(str[i])) {
                if (max < length) {
                    max = length;
                }
                int j = array.indexOf(new Character(str[i]));
                length = array.size() - j;
                do {
                    array.remove(0);
                    j--;
                } while (j >= 0);
                array.add(str[i]);
            } else {
                length++;
                array.add(str[i]);
            }
        }
        if (max < length) {
            max = length;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("e"));
        System.out.println(new Solution().lengthOfLongestSubstring("aab"));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}
