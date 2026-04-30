class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,Boolean> dp = new HashMap<>();
        dp.put(s.length(),true);
        Set<String> set = new HashSet<>();
        for(String t : wordDict){
            set.add(t);
        }
        return dfs(s,set,dp,0);
    }
    public boolean dfs(String s, Set<String> set,Map<Integer,Boolean> dp, int i ){
        if(dp.containsKey(i))    return dp.get(i);
        for(int j = i+1; j<=s.length(); j++){
            if(set.contains(s.substring(i,j))&&dfs(s,set,dp,j)){
                dp.put(i,true);
                return true;
            }
        }
        dp.put(i,false);
        return false;
    }
}
