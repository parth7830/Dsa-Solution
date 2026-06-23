class LFUCache {

    class Node {
        int key, val, freq;
        Node(int k, int v) { key = k; val = v; freq = 1; }
    }

    int capacity, minFreq;
    HashMap<Integer, Node> keyMap;              // key → node
    HashMap<Integer, LinkedHashSet<Integer>> freqMap;  // freq → keys (LRU order)

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq  = 0;
        keyMap  = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        updateFreq(node);                      // increment frequency
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);                  // already exists → update freq

        } else {
            if (keyMap.size() == capacity) {
                // evict LFU → least freq, LRU among ties
                LinkedHashSet<Integer> minSet = freqMap.get(minFreq);
                int evictKey = minSet.iterator().next();  // LRU in min freq bucket
                minSet.remove(evictKey);
                keyMap.remove(evictKey);
            }

            // add new node with freq=1
            Node node = new Node(key, value);
            keyMap.put(key, node);
            freqMap.computeIfAbsent(1, z -> new LinkedHashSet<>()).add(key);
            minFreq = 1;                       // new node always has freq=1
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;

        // remove from old freq bucket
        freqMap.get(oldFreq).remove(node.key);
        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (minFreq == oldFreq) minFreq++;  // update minFreq
        }

        // add to new freq bucket
        node.freq++;
        freqMap.computeIfAbsent(node.freq, z -> new LinkedHashSet<>()).add(node.key);
    }
}