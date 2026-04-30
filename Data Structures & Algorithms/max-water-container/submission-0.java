class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i=0;
        int j=n-1;
        int best=0;
        while(i<j){
            int cap = (j-i)*Math.min(heights[i],heights[j]);
            if(cap>best){
                best = cap;
            }
            if(heights[i]<heights[j]) i++;
            else j--;
        }
        return best;
    }
}
