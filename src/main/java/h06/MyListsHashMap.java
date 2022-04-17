package h06;

import java.util.LinkedList;

public class MyListsHashMap<K, V> implements MyMap<K, V> {
    private final LinkedList<KeyValuePair<K, V>>[] table;
    private final Fct2Int<K> hashFunction;

    /**
     * Creates a new list hash map.
     *
     * @param hashFunction The used hash function.
     */
    @SuppressWarnings("unchecked")
    public MyListsHashMap(Fct2Int<K> hashFunction) {
        this.table = new LinkedList[hashFunction.getTableSize()];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedList<>();
        }
        this.hashFunction = hashFunction;
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
}
