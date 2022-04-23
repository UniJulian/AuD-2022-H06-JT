package h06;

import org.jetbrains.annotations.Nullable;

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
        throw new RuntimeException("H4 - not implemented"); // TODO: H4 - remove if implemented
    }

    @Override
    public @Nullable V getValue(K key) {
        throw new RuntimeException("H4 - not implemented"); // TODO: H4 - remove if implemented
    }

    @Override
    public @Nullable V put(K key, V value) {
        throw new RuntimeException("H4 - not implemented"); // TODO: H4 - remove if implemented
    }

    @Override
    public @Nullable V remove(K key) {
        throw new RuntimeException("H4 - not implemented"); // TODO: H4 - remove if implemented
    }
}
