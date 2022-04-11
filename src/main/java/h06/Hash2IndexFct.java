package h06;

public class Hash2IndexFct<T> implements Fct2Int<T> {
    /**
     * Offset used in calculation.
     */
    private final int offset;
    /**
     * Table size used in calculation.
     */
    private int tableSize;

    /**
     * Creates a new hash function h(x) = (x + offset) mod tableSize.
     *
     * @param initTableSize Initial table size used in calculation.
     * @param offset        Offset used in calculation.
     */
    public Hash2IndexFct(int initTableSize, int offset) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    /**
     * Calculates the hash value of parameter "key".
     *
     * @param key The key from which to calculate the hash value.
     * @return key.hashCode() modulo tableSize
     */
    @Override
    public int apply(T key) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    /**
     * Returns the current table size.
     *
     * @return Current table size.
     */
    @Override
    public int getTableSize() {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    /**
     * Sets the current table size.
     *
     * @param tableSize New table size.
     */
    @Override
    public void setTableSize(int tableSize) {
        // TODO
        throw new RuntimeException("Not implemented");
    }
}
