class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int first = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))>=first){
                    max = Math.max(max, i-first);
                    first = map.get(s.charAt(i))+1;
                }
            }
            map.put(s.charAt(i),i);
        }
        return Math.max(max,s.length()-first);
    }
}
