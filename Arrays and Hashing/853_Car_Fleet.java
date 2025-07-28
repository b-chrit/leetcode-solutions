class Solution {
    class Car {
        int position;
        int speed;
        
        Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
        
        double timeToTarget(int target) {
            return (double)(target - position) / speed;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        
        Arrays.sort(cars, (a, b) -> Integer.compare(b.position, a.position));
        
        int fleets = 0;
        double prevTime = 0;
        
        for (Car car : cars) {
            double timeToTarget = car.timeToTarget(target);
            
            if (timeToTarget > prevTime) {
                fleets++;
                prevTime = timeToTarget;
            }
        }
        
        return fleets;
    }
}
