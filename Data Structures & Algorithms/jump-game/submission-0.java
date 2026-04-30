class Solution {
    public boolean canJump(int[] nums) {
        int post = nums.length-1;
        for(int i = post; i>=0; i--){
            if(nums[i]>=post-i){
                post = i;
            }
        }
        return post == 0;
    }
}
