class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> reps= new HashMap<>();
        HashMap<Character, Integer> occur= new HashMap<>();
        int l = 0, formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        for(Character c : t.toCharArray()){
            reps.put(c,reps.getOrDefault(c,0)+1);
        }
        for(int r = 0; r < s.length(); r++){
            Character c = s.charAt(r);
            occur.put(c,occur.getOrDefault(c,0)+1);  
            if (reps.containsKey(c) && occur.get(c).intValue() == reps.get(c).intValue()) {
                formed++;
            }
            while (formed == reps.size()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                char leftChar = s.charAt(l);
                occur.put(leftChar, occur.get(leftChar) - 1);
                if (reps.containsKey(leftChar) && occur.get(leftChar) < reps.get(leftChar)) {
                    formed--;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
