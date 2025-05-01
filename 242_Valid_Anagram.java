class Solution {
    // public static boolean isAnagram(String str1, String str2) {
    //     // Remove whitespace and convert to lowercase
    //     str1 = str1.replaceAll("\\s", "").toLowerCase();
    //     str2 = str2.replaceAll("\\s", "").toLowerCase();

    //     if (str1.length() != str2.length()) {
    //         return false;
    //     }

    //     char[] charArray1 = str1.toCharArray();
    //     char[] charArray2 = str2.toCharArray();
    //     Arrays.sort(charArray1);
    //     Arrays.sort(charArray2);

    //     return Arrays.equals(charArray1, charArray2);
    // }


     public static boolean isAnagram(String str1, String str2) {
        // Remove whitespace and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}