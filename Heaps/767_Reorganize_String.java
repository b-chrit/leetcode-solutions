// Logic: Always pick the most frequent letter, but never use the same letter twice in a row
// Use a max heap to get the most frequent letter, and a "prev" variable to enforce alternation

class Solution {
    class Pair {
        char ch;
        int count;
        
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        
        for (char character : freqMap.keySet()) {
            int count = freqMap.get(character);
            maxHeap.offer(new Pair(character, count));
        }
        
        StringBuilder result = new StringBuilder();
        Pair prev = null;
        
        while (!maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.append(current.ch);
            current.count--;
            
            if (prev != null && prev.count > 0) {
                maxHeap.offer(prev);
            }
            
            prev = current;
        }
        
        return result.length() == s.length() ? result.toString() : "";
    }
}
