package h06;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
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
        LinkedList<KeyValuePair<K,V>> list  = table[hashFunction.apply(key)];

        for(KeyValuePair<K, V> kvKeyValuePair : list){
            if(kvKeyValuePair.getKey().equals(key))
                return true;
        }
        return false;

    }

    @Override
    public @Nullable V getValue(K key) {
        LinkedList<KeyValuePair<K,V>> list  = table[hashFunction.apply(key)];

        for(KeyValuePair<K, V> iti : list){
            if(iti.getKey().equals(key))
                return iti.getValue();
        }
        return null;
    }

    @Override
    public @Nullable V put(K key, V value) {
        LinkedList<KeyValuePair<K,V>> list  = table[hashFunction.apply(key)];
        Iterator<KeyValuePair<K,V>> iti = list.iterator();
        V returnVal = null;
        while(iti.hasNext()){
            KeyValuePair<K,V> temp = iti.next();
            if(temp.getKey().equals(key) )
                returnVal = temp.getValue();
        }

        table[hashFunction.apply(key)].add(0,new KeyValuePair<>(key,value));

        return returnVal;
    }

    @Override
    public @Nullable V remove(K key) {
        int hash = hashFunction.apply(key);
        LinkedList<KeyValuePair<K,V>> list  = table[hash];
        Iterator<KeyValuePair<K,V>> iti = list.iterator();
        KeyValuePair<K,V> currVal;
        V returnVal = null;
        int index = 0;


        while(iti.hasNext()){
            currVal = iti.next();
            if(currVal.getKey().equals(key)){
                returnVal = currVal.getValue();
            }else{
                if(iti.hasNext())
                    index++;
            }
        }

        table[hash].remove(index);


        return returnVal;
    }
}
