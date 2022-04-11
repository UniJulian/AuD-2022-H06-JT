package h06;

public class MyIndexHoppingHashMap<K, V> implements MyMap<K, V> {
    private final double resizeThreshold;
    private final double resizeFactor;
    private final BinaryFct2Int<K> hashFunction;
    private K[] theKeys;
    private V[] theValues;
    private boolean[] occupiedSinceLastRehash;
    private int occupiedCount = 0;

    /**
     * Create a new index hopping hash map.
     *
     * @param initialSize     The initial size of the hashmap.
     * @param resizeFactor    The resize factor which determines the new size after the resize threshold is reached.
     * @param resizeThreshold The threshold after which the hash table is resized.
     * @param hashFunction    The used hash function.
     */
    @SuppressWarnings("unchecked")
    public MyIndexHoppingHashMap(int initialSize, double resizeFactor, double resizeThreshold, BinaryFct2Int<K> hashFunction) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean containsKey(K key) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    @Override
    public V getValue(K key) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    @Override
    public V put(K key, V value) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    @Override
    public V remove(K key) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    /***
     * Creates a new bigger hashtable (current size multiplied by resizeFactor)
     * and inserts all elements of the old hashtable into the new one.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        // TODO
        throw new RuntimeException("Not implemented");
    }
}
