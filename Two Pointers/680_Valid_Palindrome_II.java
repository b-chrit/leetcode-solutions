public class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, false);
    }

    private boolean helper(String s, int left, int right, boolean deleted) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (deleted) return false;
                return helper(s, left + 1, right, true) || helper(s, left, right - 1, true);
            }
            left++;
            right--;
        }
        return true;
    }
}
