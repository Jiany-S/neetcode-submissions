class Solution {
    public boolean isPalindrome(String s) {
        char front;
        char end;
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            front = s.charAt(i);
            end=s.charAt(j);
            if(!Character.isLetterOrDigit(front)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }
            if(Character.toLowerCase(front)!=Character.toLowerCase(end))
                return false;
            j--;
            i++;
        }
        return true;
    }
}
