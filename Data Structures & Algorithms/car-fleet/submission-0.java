class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0])); // by position desc

        int fleets = 0;
        double maxTime = -1.0;
        for (int[] c : cars) {
            double t = (target - c[0]) / (double) c[1];
            if (t > maxTime) {      
                fleets++;
                maxTime = t;
            }                       
        }
        return fleets;
    }
}
