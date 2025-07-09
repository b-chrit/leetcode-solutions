class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> validCoupons = new ArrayList<>();
        List<String> validBusinessForCoupons = new ArrayList<>();
        
        Map<String, Integer> businessOrder = new HashMap<>();
        businessOrder.put("electronics", 0);
        businessOrder.put("grocery", 1);
        businessOrder.put("pharmacy", 2);
        businessOrder.put("restaurant", 3);
        
        Set<String> validBusinessLines = new HashSet<>();
        validBusinessLines.add("electronics");
        validBusinessLines.add("grocery");
        validBusinessLines.add("pharmacy");
        validBusinessLines.add("restaurant");
        
        for (int i = 0; i < code.length; i++) {
            if (isValidCoupon(code[i], businessLine[i], isActive[i], validBusinessLines)) {
                validCoupons.add(code[i]);
                validBusinessForCoupons.add(businessLine[i]);
            }
        }
        
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < validCoupons.size(); i++) {
            indices.add(i);
        }
        
        indices.sort((a, b) -> {
            String businessA = validBusinessForCoupons.get(a);
            String businessB = validBusinessForCoupons.get(b);
            
            int orderA = businessOrder.get(businessA);
            int orderB = businessOrder.get(businessB);
            
            if (orderA != orderB) {
                return Integer.compare(orderA, orderB);
            }
            
            return validCoupons.get(a).compareTo(validCoupons.get(b));
        });
        
        List<String> result = new ArrayList<>();
        for (int i : indices) {
            result.add(validCoupons.get(i));
        }
        
        return result;
    }
    
    private boolean isValidCoupon(String code, String businessLine, boolean isActive, Set<String> validBusinessLines) {
        if (!isActive) {
            return false;
        }
        
        if (code == null || code.isEmpty()) {
            return false;
        }
        
        for (char c : code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        
        return validBusinessLines.contains(businessLine);
    }
}
