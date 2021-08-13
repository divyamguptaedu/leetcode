"""
Performance:
Runtime: 49 ms, faster than 50.93% of Java online submissions for LRU Cache.
Memory Usage: 112.2 MB, less than 42.46% of Java online submissions for LRU Cache.
"""

class LRUCache {

    private class Node {
        int val;
        int key;
        Node prev;
        Node next;
    }
    
    private int capacity;
    private Node dummyHead;
    private Node dummyTail;
    private Map<Integer, Node> map; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new Node();
        dummyTail = new Node();
        map = new HashMap<Integer, Node>();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = map.containsKey(key) ? map.get(key) : new Node();
        node.val = value;
        node.key = key;
        map.put(key, node);
        moveToHead(node);
        if (map.size() > capacity) {
            Node last = dummyTail.prev;
            last.prev.next = dummyTail;
            dummyTail.prev = last.prev;
            map.remove(last.key);
        }
    }
    
    private void moveToHead(Node node) {
        if (node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } 
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
    }
}