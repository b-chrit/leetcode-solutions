// Time: O(|s| + |t|), Space: O(1) - fixed 128-size array
// Logic: Sliding window - expand right until valid window found, then contract left 
// to find minimum while valid. Once window breaks, continue expanding to find next 
// valid window, giving every position opportunity to be optimal starting point.
class Solution {
   public String minWindow(String s, String t) {
       if (t.length() == 0 || s.length() < t.length()) return "";
       
       int[] need = new int[128];
       for (char c : t.toCharArray()) need[c]++;
       
       int required = t.length();
       int left = 0, start = 0, minLen = Integer.MAX_VALUE;
       
       for (int right = 0; right < s.length(); right++) {
           char rc = s.charAt(right);
           if (need[rc] > 0) required--;
           need[rc]--;
           
           while (required == 0) {
               if (right - left + 1 < minLen) {
                   minLen = right - left + 1;
                   start = left;
               }
               char lc = s.charAt(left++);
               need[lc]++;
               if (need[lc] > 0) required++;
           }
       }
       
       return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
   }
}
