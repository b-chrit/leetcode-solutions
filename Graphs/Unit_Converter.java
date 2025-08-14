import java.util.*;

class UnitConverterDFS {
    class Edge {
        String to;
        double factor;
        
        Edge(String to, double factor) {
            this.to = to;
            this.factor = factor;
        }
    }
    
    private final Map<String, List<Edge>> graph = new HashMap<>();
    
    public void addConversion(String from, String to, double factor) {
        if (!graph.containsKey(from)) graph.put(from, new ArrayList<>());
        if (!graph.containsKey(to)) graph.put(to, new ArrayList<>());
        
        graph.get(from).add(new Edge(to, factor));
        graph.get(to).add(new Edge(from, 1.0 / factor));
    }
    
    public double convert(String from, String to, double amount) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) return -1.0;
        if (from.equals(to)) return amount;
        
        Set<String> visited = new HashSet<>();
        double multiplier = dfs(from, to, 1.0, visited);
        return multiplier == -1.0 ? -1.0 : amount * multiplier;
    }
    
    private double dfs(String current, String target, double accumulated, Set<String> visited) {
        if (current.equals(target)) return accumulated;
        
        visited.add(current);
        for (Edge edge : graph.get(current)) {
            if (!visited.contains(edge.to)) {
                double result = dfs(edge.to, target, accumulated * edge.factor, visited);
                if (result != -1.0) return result;
            }
        }
        visited.remove(current);
        return -1.0;
    
    public static void main(String[] args) {
        UnitConverterDFS converter = new UnitConverterDFS();
        converter.addConversion("m", "ft", 3.28084);
        converter.addConversion("ft", "in", 12);
        
        System.out.println(converter.convert(1, "m", "in"));
        System.out.println(converter.convert(1, "m", "ft"));
    }
}

class UnitConverterBFS {
    class Edge {
        String to;
        double factor;
        
        Edge(String to, double factor) {
            this.to = to;
            this.factor = factor;
        }
    }
    
    class State {
        String unit;
        double multiplier;
        
        State(String unit, double multiplier) {
            this.unit = unit;
            this.multiplier = multiplier;
        }
    }
    
    private final Map<String, List<Edge>> graph = new HashMap<>();
    
    public void addConversion(String from, String to, double factor) {
        if (!graph.containsKey(from)) graph.put(from, new ArrayList<>());
        if (!graph.containsKey(to)) graph.put(to, new ArrayList<>());
        graph.get(from).add(new Edge(to, factor));
        graph.get(to).add(new Edge(from, 1.0 / factor));
    }
    
    public double convert(String from, String to, double amount) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) return -1.0;
        if (from.equals(to)) return amount;
        
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(new State(from, 1.0));
        visited.add(from);
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            for (Edge edge : graph.get(current.unit)) {
                double newMultiplier = current.multiplier * edge.factor;
                
                if (edge.to.equals(to)) {
                    return amount * newMultiplier;
                }
                
                if (!visited.contains(edge.to)) {
                    visited.add(edge.to);
                    queue.offer(new State(edge.to, newMultiplier));
                }
            }
        }
    
    public static void main(String[] args) {
        UnitConverterBFS converter = new UnitConverterBFS();
        converter.addConversion("m", "ft", 3.28084);
        converter.addConversion("ft", "in", 12);
        
        System.out.println(converter.convert(1, "m", "in"));
        System.out.println(converter.convert(1, "m", "ft"));
    }
}
