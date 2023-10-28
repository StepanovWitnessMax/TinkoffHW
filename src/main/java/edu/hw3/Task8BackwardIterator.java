package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Task8BackwardIterator<T> implements Iterator<T> {

    private final List<T> list;
    private int pointer;

    public Task8BackwardIterator(Collection<T> collection) {
        this.pointer = collection.size() - 1;
        this.list = collection.stream().toList();
    }

    @Override
    public boolean hasNext() {
        return pointer >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return this.list.get(pointer--);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
