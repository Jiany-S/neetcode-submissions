class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        dfs(ans,digits,0,"");
        return ans;
    }
    void dfs(List<String> ans, String s, int i, String curr){
        if(i==s.length()){
            if(curr!="")
                ans.add(curr);
            return;
        }
        int dig = s.charAt(i)-'0';
        int lim = dig==7||dig==9 ? 4:3;
        int plus = dig==8||dig==9 ? 1:0;
        for(int j = 0; j<lim;j++){
            curr+=(char)('a'+3*(dig-2)+j+plus)+"";
            dfs(ans,s,i+1,curr);
            curr= curr.substring(0,curr.length()-1);
        }
    }
}
