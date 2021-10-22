package algo;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
class RandomizedSet {
    private final Map<Integer, Integer> mapping;
    private final List<Integer> keys;
    private final Random r;

    public RandomizedSet() {
        mapping = new HashMap<>();
        keys = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (mapping.containsKey(val)) {
            return false;
        } else {
            mapping.put(val, keys.size());
            keys.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (mapping.containsKey(val)) {
            // replace element at index with the last element in order not to shift elements in list
            Integer index = mapping.get(val);
            if (index != keys.size() - 1) {
                int lastKey = keys.get(keys.size() - 1);
                keys.set(index, lastKey);
                mapping.put(lastKey, index);
            }

            keys.remove(keys.size() - 1);
            mapping.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return keys.get(r.nextInt(keys.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
