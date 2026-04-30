class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c : s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> curr = new HashMap<>();
        int l = 0;
        for(int r = 0; r < s2.length(); r++){
            Character c = s2.charAt(r);
            curr.put(c,curr.getOrDefault(c,0)+1);
            while(curr.get(c)>map.getOrDefault(c,0)){
                curr.put(s2.charAt(l),curr.get(s2.charAt(l))-1);
                l++;
            }
            if(r-l+1==s1.length())
                return true;
        }
        return s2.length()-l==s1.length();
    }
}
