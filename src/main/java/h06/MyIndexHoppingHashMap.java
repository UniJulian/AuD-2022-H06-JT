package h06;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

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
        int hash;
        do{
            hash = hashFunction.apply(key, i);
            if(theKeys[hash].equals(key))
                return hash;
            i++;
        }while(occupiedSinceLastRehash[hash]);
        return -1;
    }
    private void changeValue(int index, K key, V value, int occ) {
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
            return null;
        return theValues[index];
    }

    @Override
    public @Nullable V put(K key, V value) {
        if(key == null)
            return null;
        int i = 0;
        int hash;
        K currKey;

        if((theKeys.length * resizeThreshold) < (occupiedCount + 1))
            rehash();

        do{
            hash= hashFunction.apply(key, i);
            currKey = theKeys[hash];

            if(currKey == null)
                break;
            if(currKey.equals(key)){

                V returnVal = theValues[hash];
                changeValue(hash,key,value,0);
                return returnVal;
            }
            occupiedSinceLastRehash[hash] = true;
            i++;
        } while(true);

        changeValue(hash,key,value,1);
        return null;
    }

    @Override
    public @Nullable V remove(K key) {
        int i = 0;
        int hash;
        K currKey;
        int prevHash = -1;

        do{
            hash = hashFunction.apply(key, i);
            currKey = theKeys[hash];
            if(currKey == null){
                if(!occupiedSinceLastRehash[hash])
                    return null;
            }
            else if(currKey.equals(key)){
                V returnVal = theValues[hash];
                changeValue(hash,null,null,-1);
                if(!occupiedSinceLastRehash[hash] && (prevHash != -1))
                    occupiedSinceLastRehash[prevHash] = false;
                return returnVal;
            }
            i++;
            prevHash = hash;
        } while(true);

    }

    /***
     * Creates a new bigger hashtable (current size multiplied by resizeFactor)
     * and inserts all elements of the old hashtable into the new one.
     */
    @SuppressWarnings("unchecked")
    private void rehash() {
        int newSize = (int) (theKeys.length * resizeFactor);
        K[] theKeysOLD = theKeys;
        V[] theValuesOLD = theValues;

        theKeys =(K[]) new Object[newSize];
        theValues =(V[]) new Object[newSize];
        occupiedSinceLastRehash = new boolean[newSize];
        hashFunction.setTableSize(newSize);
        occupiedCount = 0;

        for (int i = 0; i < theKeysOLD.length; i++) {
            put(theKeysOLD[i],theValuesOLD[i]);
        }
    }
}
