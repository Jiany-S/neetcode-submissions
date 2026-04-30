class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int r = Math.min(nums.length,k);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] ans = new int[nums.length-k+1];
        for(int i = 0; i<Math.min(nums.length,k); i++){
            heap.add(new int[]{nums[i],i});
        }
        ans[0]=heap.peek()[0];
        for(int l = 1; l<=nums.length-k;l++){
            heap.add(new int[]{nums[l+k-1],l+k-1});
            while(heap.peek()[1]<l)
                heap.poll();
            ans[l]=heap.peek()[0];
        }
        ans[nums.length-k]=heap.peek()[0];
        return ans;
    }
}
