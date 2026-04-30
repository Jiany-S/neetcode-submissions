class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int i=0;
        while(i<n-2){
            if (i > 0 && nums[i] == nums[i - 1]){
                i++;
                continue;   
            }
            int target = - nums[i];
            int j = i + 1;
            int k = n - 1;
            while(j<k){
                if(nums[j]+nums[k]==target) {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
                else if(nums[k]>target-nums[j])
                    k--;
                else if(nums[j]<target-nums[k])
                    j++;
                
            }
            i++;
        }
        return ans;
    }
}
