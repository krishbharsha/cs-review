package com.mmnaseri.cs.clrs.ch11.s1;

import com.mmnaseri.cs.clrs.ch11.HashTable;
import com.mmnaseri.cs.qa.annotation.Quality;
import com.mmnaseri.cs.qa.annotation.Stage;

/**
 * @author Mohammad Milad Naseri (mmnaseri@programmer.net)
 * @since 1.0 (7/13/15)
 */
@Quality(Stage.TESTED)
public class DirectAddressingHashTable<E> implements HashTable<E> {

    private static final Object NULL = new Object();
    private final Object[] storage;
    private final int capacity;
    private int size;

    public DirectAddressingHashTable(int capacity) {
        this.capacity = capacity;
        storage = new Object[this.capacity];
        size = 0;
    }

    @Override
    public E get(int index) {
        Object item = storage[index];
        if (item == NULL) {
            return null;
        }
        //noinspection unchecked
        return (E) item;
    }

    @Override
    public void put(int index, E item) {
        if (storage[index] == null) {
            size ++;
        }
        if (item == null) {
            storage[index] = NULL;
        } else {
            storage[index] = item;
        }
    }

    @Override
    public void delete(int index) {
        if (storage[index] != null) {
            size --;
        }
        storage[index] = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

}
