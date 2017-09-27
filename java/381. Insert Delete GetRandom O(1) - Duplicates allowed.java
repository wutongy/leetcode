// O(1) average
class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    ArrayList<Integer> vals;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        vals = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean existed = !map.containsKey(val);
        map.putIfAbsent(val, new HashSet<>());
        vals.add(val);
        map.get(val).add(vals.size() - 1);
        return existed;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Set<Integer> valList = map.get(val);
        if (valList.contains(vals.size() - 1)) {
            valList.remove(vals.size() - 1);
        } else {
            int idx = valList.iterator().next();
            int endVal = vals.get(vals.size() - 1);
            vals.set(idx, endVal);
            map.get(endVal).remove(vals.size() - 1);
            map.get(endVal).add(idx);
            valList.remove(idx);
        }
        if (valList.size() == 0) {
            map.remove(val);
        }
        vals.remove(vals.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(r.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
