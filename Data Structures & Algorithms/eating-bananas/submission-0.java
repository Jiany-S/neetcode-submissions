class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int r = piles[n-1];
        int l=1;
        while(l<=r){
            int time = 0;
            int mid = (l+r)/2;
            for (int i = 0; i<n; i++){
                time+= (piles[i] + mid - 1) / mid;
            }
            if(time<=h){
                r=mid-1;
            }
            else
                l = mid+1;
        }
        return l;
    }
}
