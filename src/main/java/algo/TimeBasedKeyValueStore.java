package algo;

import java.util.*;

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
class TimeMap {
    Map<String, NavigableMap<Integer, String>> stash;

    /** Initialize your data structure here. */
    public TimeMap() {
        stash = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        NavigableMap<Integer, String> tsMapping = stash.putIfAbsent(key, new TreeMap<Integer, String>() {{
            put(timestamp, value);
        }});

        if (tsMapping != null) {
            tsMapping.put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {
        if (stash.containsKey(key)) {
            NavigableMap<Integer, String> tsMapping = stash.get(key);
            Integer prevTs = tsMapping.floorKey(timestamp);
            return prevTs != null ? tsMapping.getOrDefault(prevTs, "") : "";
        } else {
            return "";
        }
    }
}
