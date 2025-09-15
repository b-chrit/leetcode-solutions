import java.util.*;

/*
 * LeetCode 271: Encode and Decode Strings
 * 
 * Design an algorithm to encode a list of strings to a string and decode it back.
 * The encoded string should be able to handle any characters including delimiters.
 * Note: Do not use static data structures like class variables or global maps.
 * 
 * Example:
 * Input: ["hello", "world", ""]
 * encode() -> "5#hello5#world0#"
 * decode("5#hello5#world0#") -> ["hello", "world", ""]
 * 
 * Format: length + "#" + string (repeated for each string)
 */

public class Solution {
    
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }
    
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int delimiterIndex = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            int start = delimiterIndex + 1;
            result.add(s.substring(start, start + length));
            i = start + length;
        }
        
        return result;
    }
}
