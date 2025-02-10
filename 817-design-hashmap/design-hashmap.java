class MyHashMap {
    private static final int SIZE = 1000; // Size of the bucket array
    private LinkedList<Node>[] buckets;   // Array of linked lists

    // Node class to store key-value pairs
    private static class Node {
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    private int findIndex(LinkedList<Node> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                return i; // Return the index of the node with the given key
            }
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        int pos = findIndex(buckets[index], key);
        if (pos == -1) {
            buckets[index].add(new Node(key, value)); // Add new node
        } else {
            buckets[index].get(pos).value = value; // Update existing node value
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1; // Key does not exist
        }
        int pos = findIndex(buckets[index], key);
        return (pos == -1) ? -1 : buckets[index].get(pos).value;
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) return;

        int pos = findIndex(buckets[index], key);
        if (pos != -1) {
            buckets[index].remove(pos); // Remove the key-value pair
        }
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */