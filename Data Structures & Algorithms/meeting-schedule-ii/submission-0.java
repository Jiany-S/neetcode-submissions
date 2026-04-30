/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]); 
        });
        for(Interval v : intervals){
            heap.add(new int[]{v.start,1});
            heap.add(new int[]{v.end,0});
        }
        int curr = 0;
        int max = 0; 
        while(!heap.isEmpty()){
            int[] t = heap.poll();
            if(t[1]==1) curr++;
            else curr--;
            max = Math.max(curr,max);
        }
        return max;
    }
}
