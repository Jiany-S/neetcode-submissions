class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r])
                l = mid + 1;  
            else
                r = mid;                         
        }
        int cut = l;
        int l1,r1;
        if(target>=nums[cut]&&target<=nums[nums.length-1]){
            l1 = cut;
            r1 = nums.length-1;
        }
        else{
            l1 = 0;
            r1 = cut-1;
        }
        while(l1<=r1){
            int mid1 = l1+(r1-l1)/2;
            if(nums[mid1]==target)
                return mid1;
            if(nums[mid1]<target)
                l1=mid1+1;
            else
                r1 = mid1-1;
        }
        return -1;
    }
}
