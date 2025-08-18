class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            
            String id1 = split1[0];
            String content1 = split1[1];
            String id2 = split2[0];
            String content2 = split2[1];
            
            boolean isDigit1 = Character.isDigit(content1.charAt(0));
            boolean isDigit2 = Character.isDigit(content2.charAt(0));
            
            if (isDigit1 && isDigit2) {
                return 0;
            }
            
            if (isDigit1) {
                return 1;
            }
            if (isDigit2) {
                return -1;
            }
            
            int contentComparison = content1.compareTo(content2);
            if (contentComparison != 0) {
                return contentComparison;
            }
            return id1.compareTo(id2);
        });
        
        return logs;
    }
}
