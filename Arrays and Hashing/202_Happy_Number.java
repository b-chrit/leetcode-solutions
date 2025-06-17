class Solution {
    public boolean isHappy(int n) {
        int slow = findNumber(n);
        int fast = findNumber(n);

        do{
            fast = findNumber(findNumber(fast));
            slow = findNumber(slow);
        }while(fast != slow);

        if(slow == 1) return true;

        return false;
    }

    public int findNumber(int n){
        int result = 0;

        while(n > 0){
            int lastDigit = n % 10;
            result += lastDigit * lastDigit;
            n = n / 10;
        }

        return result;
    }
}
