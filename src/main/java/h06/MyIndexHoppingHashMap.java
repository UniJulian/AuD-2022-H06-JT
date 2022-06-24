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
        int i = 0;

        while(theKeys[hashFunction.apply(key, i)] != null) {
            if(theKeys[hashFunction.apply(key, i)].equals(key))
                return hashFunction.apply(key, i);
            i++;
        }
        return -1;
    }
    private void changeValue(int index, K key, V value, boolean bol, int occ) {
        occupiedSinceLastRehash[index] = bol;
        theValues[index] = value;
        theKeys[index] = key;
        occupiedCount += occ;
    }

    @Override
    public boolean containsKey(K key) {
        return indexSearcher(key) != -1;
    }

    @Override
    public @Nullable V getValue(K key) {
        int index = indexSearcher(key);
        if(index == -1)
            throw new IllegalArgumentException();
        return theValues[index];
    }

    @Override
    public @Nullable V put(K key, V value) {
        int i = 0;
        while(theKeys[hashFunction.apply(key, i)] != null) {
            if(theKeys[hashFunction.apply(key, i)].equals(key)){
                V returnVal = theValues[hashFunction.apply(key, i)];
                changeValue(hashFunction.apply(key, i),key,value,true,0);
                return returnVal;
            }
            i++;
        }
        changeValue(hashFunction.apply(key, i),key,value,true,1);
        return null;
    }

    @Override
    public @Nullable V remove(K key) {
        int i = 0;
        if((theKeys.length * resizeFactor) < (occupiedCount + 1))
            rehash();

        while(theKeys[hashFunction.apply(key, i)] != null) {
            if(theKeys[hashFunction.apply(key, i)].equals(key)){
                V returnVal = theValues[hashFunction.apply(key, i)];
                changeValue(hashFunction.apply(key, i),null,null,false,-1);
                return returnVal;
            }
            i++;
        }
        return null;
    }

    /***
     * Creates a new bigger hashtable (current size multiplied by resizeFactor)
     * and inserts all elements of the old hashtable into the new one.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {

        int newSize = (int) Math.round(theKeys.length * resizeFactor);




    }
}
