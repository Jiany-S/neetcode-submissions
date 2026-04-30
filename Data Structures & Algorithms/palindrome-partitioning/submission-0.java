class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans,0,0,s, new ArrayList<String>());
        return ans;
    }
    void backtrack(List<List<String>> ans, int i,int j , String s, List<String> curr){
        if(j>=s.length()){
            if(i==s.length())
                ans.add(new ArrayList<>(curr));
            return;
        }
        if(isPalindrome(s.substring(i,j+1))){
            curr.add(s.substring(i,j+1));
            backtrack(ans,j+1,j+1,s,curr);
            curr.remove(curr.size()-1);
        }
            backtrack(ans,i,j+1,s,curr);
    }
    public boolean isPalindrome(String s){
        int l= 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
}
