class RandomizedSet {
    
    private final List<Integer> list;
    private final Map<Integer, Integer> valIdxMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>(10);
        valIdxMap = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valIdxMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        valIdxMap.put(val, list.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer idx = valIdxMap.get(val);
        if (idx != null) {
            Collections.swap(list, idx, list.size() - 1);
            int lastElement = list.get(idx); // lastElement swapped to a new index
            valIdxMap.put(lastElement, idx); // update this index in map
            list.remove(list.size() - 1); // remove last element from list and map
            valIdxMap.remove(val);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randIdx = (int) (valIdxMap.size() * Math.random());
        return list.get(randIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
