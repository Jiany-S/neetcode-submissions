class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length == 0)
            return 0;
        int min = 0;
        int ans=0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i]-prices[min]>ans)
                ans = prices[i]-prices[min];
            if(prices[i]<prices[min])
                min = i;
        }
        return ans;
    }
}
