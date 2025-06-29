class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() == 0) {
            return "Neither";
        }
        
        if (queryIP.contains(".")) {
            return isValidIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return isValidIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }
    
    private boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        
        if (parts.length != 4) {
            return false;
        }
        
        for (String part : parts) {
            if (!isValidIPv4Part(part)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidIPv4Part(String part) {
        if (part == null || part.length() == 0) {
            return false;
        }
        
        if (part.length() > 3) {
            return false;
        }
        
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        
        for (char c : part.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        
        int value = Integer.parseInt(part);
        return value >= 0 && value <= 255;
    }
    
    private boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        
        if (parts.length != 8) {
            return false;
        }
        
        for (String part : parts) {
            if (!isValidIPv6Part(part)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidIPv6Part(String part) {
        if (part == null || part.length() == 0) {
            return false;
        }
        
        if (part.length() > 4) {
            return false;
        }
        
        for (char c : part.toCharArray()) {
            if (!isValidHexChar(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidHexChar(char c) {
        return (c >= '0' && c <= '9') || 
               (c >= 'a' && c <= 'f') || 
               (c >= 'A' && c <= 'F');
    }
}
