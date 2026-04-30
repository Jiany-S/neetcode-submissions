class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int min = nums[0];
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<min)
                min = nums[mid];
            if(nums[mid]>nums[r]){
                l=mid+1;
            }
            else
                r = mid-1;
        }
        return min;
    }
}
