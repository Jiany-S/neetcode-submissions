class Solution {
    public boolean isAnagram(String s, String t) {
        Hashtable<Character,Integer> ta = new Hashtable<>();
        Hashtable<Character,Integer> tb = new Hashtable<>();
        for(char c : s.toCharArray()){
            ta.putIfAbsent(c,0);
            ta.put(c,ta.get(c)+1);
        }
        for(char c : t.toCharArray()){
            tb.putIfAbsent(c,0);
            tb.put(c,tb.get(c)+1);
        }
        return ta.equals(tb);
    }
}
