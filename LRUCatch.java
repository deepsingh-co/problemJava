import java.util.HashMap;

public class LRUCatch {

    static class LRUCache {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();

            // Dummy head and tail
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            // Move to most recently used position
            remove(node);
            addToEnd(node);

            return node.value;
        }

        public void put(int key, int value) {

            // Key already exists
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;

                remove(node);
                addToEnd(node);

                return;
            }

            // Add new key
            Node node = new Node(key, value);
            map.put(key, node);
            addToEnd(node);

            // Remove least recently used key
            if (map.size() > capacity) {
                Node lru = head.next;

                remove(lru);
                map.remove(lru.key);
            }
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToEnd(Node node) {
            Node last = tail.prev;

            last.next = node;
            node.prev = last;

            node.next = tail;
            tail.prev = node;
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3);                  // Removes key 2

        System.out.println(cache.get(2)); // -1

        cache.put(4, 4);                  // Removes key 1

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
