class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> byDistance = (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA);
        };
        PriorityQueue<int[]> heap = new PriorityQueue<>(byDistance);
        for(int[] i : points){
            heap.add(i);
            while(heap.size()>k)
                heap.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while(!heap.isEmpty()){
            ans[i] = heap.poll();
            i++;
        }
        return ans;
    }
}
