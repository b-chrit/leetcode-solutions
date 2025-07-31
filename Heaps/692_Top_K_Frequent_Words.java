class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0) return result;
        Map<String, Integer> freqMap = new HashMap<>();
        
        for(String word : words){
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if(freqA != freqB) {
                return freqB - freqA;
            }
            return a.compareTo(b);
        });
        for(String word : freqMap.keySet()){
            maxHeap.offer(word);
        }
        for(int i = 0; i < k; i++){
            result.add(maxHeap.poll());
        }
        return result;
    }
}
