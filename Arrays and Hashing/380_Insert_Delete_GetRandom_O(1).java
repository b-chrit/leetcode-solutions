public class RandomizedSet {
    private List<Integer> values;
    private Map<Integer, Integer> indices;
    private Random random;
    
    public RandomizedSet() {
        values = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        values.add(val);
        indices.put(val, values.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int indexToRemove = indices.get(val);
        int lastElement = values.get(values.size() - 1);
        
        values.set(indexToRemove, lastElement);
        indices.put(lastElement, indexToRemove);
        
        values.remove(values.size() - 1);
        indices.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(values.size());
        return values.get(randomIndex);
    }
}
