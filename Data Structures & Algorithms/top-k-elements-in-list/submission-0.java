class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer i : nums){
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> temp = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            temp.add(e);
            if (temp.size()>k)
                temp.poll();
        }
        int[]ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i]=temp.poll().getKey();
        }
        return ans;
    }
}
