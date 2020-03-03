package ca.java.datastructure.hashtable;

import java.util.HashMap;

public class BasicHashtable<K, V> {

    private HashEntry[] data;
    private int capacity;
    private int tableSize;

    public BasicHashtable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.tableSize = 0;

    }

    public int size() {
        return this.tableSize;
    }


    private class HashEntry<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
