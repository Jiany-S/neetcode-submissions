class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> tm = map.get(key);
        if (tm == null) return "";
        Map.Entry<Integer, String> e = tm.floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }
}
