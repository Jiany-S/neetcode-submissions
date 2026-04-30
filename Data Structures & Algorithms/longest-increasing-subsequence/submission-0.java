class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis,1);
        for(int i = nums.length-1; i>=0; i--){
            for(int j = i+1; j<nums.length; j++){
                if(nums[j]>nums[i])
                    lis[i]=Math.max(lis[i],1+lis[j]);
            }
        }
        int max = 1;
        for(int t : lis){
            max = Math.max(max,t);
        }
        return max;
    }
}
