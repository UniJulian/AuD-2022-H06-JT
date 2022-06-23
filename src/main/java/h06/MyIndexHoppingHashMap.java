package h06;

import org.jetbrains.annotations.Nullable;

public class MyIndexHoppingHashMap<K, V> implements MyMap<K, V> {
    private final double resizeThreshold;
    private final double resizeFactor;
    private K[] theKeys;
    private V[] theValues;
    private boolean[] occupiedSinceLastRehash;
    private int occupiedCount = 0;
    private final BinaryFct2Int<K> hashFunction;

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
        this.theKeys = (K[]) new Object[initialSize];
        this.theValues = (V[]) new Object[initialSize];
        this.occupiedSinceLastRehash = new boolean[initialSize];

        this.resizeFactor = resizeFactor;
        this.resizeThreshold = resizeThreshold;
        this.hashFunction = hashFunction;
        this.hashFunction.setTableSize(initialSize);
    }

    /**
     * searches the corresponding index to a given key
     *
     * HelperFct
     * @param key to be searched Key
     * @return the index
     */
    private int indexSearcher(K key){
        if(hashFunction instanceof DoubleHashing){
            return hashFunction.apply(key,1); // resizeFactor?
        }
        if(hashFunction instanceof LinearProbing){
            return hashFunction.apply(key,1); // woher offset?
        }
        throw new IllegalArgumentException(String.valueOf(key));

    }

    @Override
    public boolean containsKey(K key) {
        return theKeys[indexSearcher(key)] != null;
    }

    @Override
    public @Nullable V getValue(K key) {
        throw new RuntimeException("H3 - not implemented"); // TODO: H3 - remove if implemented
    }

    @Override
    public @Nullable V put(K key, V value) {
        throw new RuntimeException("H3 - not implemented"); // TODO: H3 - remove if implemented
    }

    @Override
    public @Nullable V remove(K key) {
        throw new RuntimeException("H3 - not implemented"); // TODO: H3 - remove if implemented
    }

    /***
     * Creates a new bigger hashtable (current size multiplied by resizeFactor)
     * and inserts all elements of the old hashtable into the new one.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        throw new RuntimeException("H3 - not implemented"); // TODO: H3 - remove if implemented
    }
}
