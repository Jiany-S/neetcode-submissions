class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans,nums,0,new ArrayList<>());
        return ans;
    }
    void backtrack(List<List<Integer>> ans, int[] nums, int ind, List<Integer> curr){
        ans.add(new ArrayList(curr));
        for(int i = ind; i<nums.length;i++){
            if(i>ind&&nums[i-1]==nums[i])
                continue;
            curr.add(nums[i]);
            backtrack(ans,nums,i+1,curr);
            curr.remove(curr.size()-1);
        }
    }
}
