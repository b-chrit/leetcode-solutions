class MyCalendar {
    TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prevStart = events.floorKey(start);
        Integer nextStart = events.ceilingKey(start);
        
        if ((prevStart == null || events.get(prevStart) <= start) && 
            (nextStart == null || nextStart >= end)) {
            events.put(start, end);
            return true;
        }
        return false;
    }
}
