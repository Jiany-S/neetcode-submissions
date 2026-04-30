class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        int max = height[0];
        for (int i = 0; i<n; i++){
            if(height[i]>max)
                max = height[i];
            prefix[i]=max;
        }
        max = height[n-1];
        for (int i = n-1; i>=0; i--){
            if(height[i]>max)
                max = height[i];
            sufix[i]=max;
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans+=Math.min(prefix[i],sufix[i])-height[i];
        }
        return ans;
    }
}
