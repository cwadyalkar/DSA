class MyHashSet {

    private static final int SIZE = 1000; // initialize SIZE of bucket
    private LinkedList<Integer>[] bucket; // Array Of LinkedList

    // Constructor to create the bucket with size
    public MyHashSet() {
        bucket = new LinkedList[SIZE];
    }

    // it is the hashFunction which give me the index in the buckets
    public int hashFunction(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        // first get the index in bucket by hash function
        int index = hashFunction(key);

        // Check if it is already exist or not
        if (bucket[index] == null) {
            bucket[index] = new LinkedList<>();
        }
        // if not then add the key
        if (!bucket[index].contains(key)) {
            bucket[index].add(key);
        }

    }

    public void remove(int key) {
        int index = hashFunction(key);
        if (bucket[index] != null) {
            bucket[index].remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        int index = hashFunction(key);
        return bucket[index] != null && bucket[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */