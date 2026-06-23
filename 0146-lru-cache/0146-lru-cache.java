class LRUCache {

    // Doubly linked list node
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;   // dummy head and tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy nodes avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToFront(node);         // recently used → front
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);     // recently used → front
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            addToFront(node);

            if (map.size() > capacity) {
                Node lru = tail.prev;    // least recently used
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }

    // ---- Helper Methods ----

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }
}