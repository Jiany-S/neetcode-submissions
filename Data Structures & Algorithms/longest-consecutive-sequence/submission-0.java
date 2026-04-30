class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }
        int max = 0;
        for(Integer i : nums){
            if(!set.contains(i-1)){
                int index = i;
                int count = 1;
                while(set.contains(index+1)){
                    count++;
                    index++;
                }
                if(count>max)
                    max=count;
            }
        }
        return max;
    }
}
