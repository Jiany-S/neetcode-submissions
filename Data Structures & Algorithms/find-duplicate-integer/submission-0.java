class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        for(int i = 0; i<len;i++){
            if(nums[Math.abs(nums[i])]<0)
                return Math.abs(nums[i]);
            nums[Math.abs(nums[i])]*=-1;
        }
        return -1;
    }
}
