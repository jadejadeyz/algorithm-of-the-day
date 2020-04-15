package hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class EntryNode {
    public int key;
    public int frequency;
    EntryNode prev, next;

    public EntryNode(int key, int frequency) {
        this.key = key;
        this.frequency = frequency;
        this.prev = null;
        this.next = null;
    }
}

class FrequencyTable {
    private Map<Integer, EntryNode> entryTable;
    private Map<Integer, ArrayDeque<EntryNode>> freqTable;

    public FrequencyTable() {
        this.entryTable = new HashMap<>();
        this.freqTable = new HashMap<>();
    }

    private EntryNode safeRemoveFromFreqTable(EntryNode node) {
        freqTable.get(node.frequency).remove(node);
        if (freqTable.get(node.frequency).size() == 0)
            freqTable.remove(node.frequency);

        return node;
    }

    public void updateFrequency(int key) {
        EntryNode node = entryTable.get(key);
        safeRemoveFromFreqTable(node);
        if (freqTable.containsKey(node.frequency+1)) {
            freqTable.get(node.frequency + 1).add(node);
            node.frequency++;
        }
        else {
            node.frequency++;
            ArrayDeque<EntryNode> list = new ArrayDeque<>();
            list.add(node);
            freqTable.put(node.frequency, list);
        }

    }

    public void insertFreqEntry(int key) {
        EntryNode node = new EntryNode(key, 1);
        entryTable.put(key, node);
        if (freqTable.containsKey(1)) {
            freqTable.get(1).add(node);
        }
        else {
            ArrayDeque<EntryNode> list = new ArrayDeque<>();
            list.add(node);
            freqTable.put(1, list);
        }
    }

    public int removeLFEntry() {
        Integer least = (Integer) freqTable.keySet().toArray()[0];
        EntryNode node = freqTable.get(least).poll();
        entryTable.remove(node.key);
        if (freqTable.get(least).size() == 0)
            freqTable.remove(least);
        else {
            freqTable.get(least).remove(node);
        }

        return node.key;
    }
}

public class LFUCache {
    private int capacity, size;
    private Map<Integer, Integer> cache;
    private FrequencyTable table;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        this.table = new FrequencyTable();
    }

    public boolean isFull() {
        return size == capacity? true: false;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            table.updateFrequency(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1)
            cache.put(key, value);
        else {
            if (isFull()) {
                int deletedKey = table.removeLFEntry();
                cache.remove(deletedKey);
                cache.put(key, value);
                table.insertFreqEntry(key);
            }
            else {
                size++;
                cache.put(key, value);
                table.insertFreqEntry(key);
            }
        }
    }
}
