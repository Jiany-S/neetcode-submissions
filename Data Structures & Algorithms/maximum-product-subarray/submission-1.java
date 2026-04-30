class Solution {
    public int maxProduct(int[] nums) {
        int curMax=1,curMin=1,res=nums[0];
        for(int n : nums){
            
            int t = curMax;
            int t1 = Math.max(n,n*t);
            curMax = Math.max(t1,n*curMin);
            t1 = Math.min(n,n*t);
            curMin = Math.min(t1,n*curMin);
            res = Math.max(res,curMax);
        }
        return res;
    }
}
