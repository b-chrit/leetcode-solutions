class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1Frequency = new int[26];
        for (char character : s1.toCharArray()) {
            s1Frequency[character - 'a']++;
        }
        
        int[] windowFrequency = new int[26];
        int windowSize = s1.length();
        
        for (int index = 0; index < windowSize; index++) {
            windowFrequency[s2.charAt(index) - 'a']++;
        }
        
        if (hasIdenticalFrequencies(s1Frequency, windowFrequency)) {
            return true;
        }
        
        for (int rightIndex = windowSize; rightIndex < s2.length(); rightIndex++) {
            windowFrequency[s2.charAt(rightIndex) - 'a']++;
            int leftIndex = rightIndex - windowSize;
            windowFrequency[s2.charAt(leftIndex) - 'a']--;
            
            if (hasIdenticalFrequencies(s1Frequency, windowFrequency)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean hasIdenticalFrequencies(int[] firstArray, int[] secondArray) {
        for (int index = 0; index < 26; index++) {
            if (firstArray[index] != secondArray[index]) {
                return false;
            }
        }
        return true;
    }
}