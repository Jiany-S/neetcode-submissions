class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> dp = new HashMap<>();
        for(int i : coins){
            dp.put(i,1);
        }
        int minC = dfs(coins,amount,dp);
        return minC==Integer.MAX_VALUE ? -1:minC;
    }
    public int dfs(int[] coins, int ammount, Map<Integer,Integer> dp){
        if(ammount==0)
            return 0;
        if(dp.containsKey(ammount)) return dp.get(ammount);
        int min = Integer.MAX_VALUE;
        for (int c : coins) {
            if (ammount - c >= 0) {
                int sub = dfs(coins, ammount - c, dp);
                if (sub != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + sub);
                }
            }
        }
        dp.put(ammount,min);
        return min;
    }
}
