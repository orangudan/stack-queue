package com.dsadeghi.stackqueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;


public class CircularArrayQueue <E> implements Collection<E>, Queue<E> {
    
    E[] queue;
    int capacity;
    int size;
    int front;
    int rear;


    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    public E element() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public boolean offer(E e) {
        if (size == capacity) {
            reallocate();
        }

        size++;
        rear = (rear + 1) % capacity;
        queue[rear] = e;
        return true;
    }

    private void reallocate() {
        int newCapacity = 2 * capacity;
        E[] newQueue = (E[]) new Object[newCapacity];
        int j = front;
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[j];
            j = (j+1) % capacity;
        }

        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        queue = newQueue;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        else {
            return queue[front];
        }
    }

    public E poll() {
        if (size == 0) {
            return null;
        } else {
            E returnData = queue[front];
            front = (front + 1) % capacity;
            size--;
            return returnData;
        }
    }

    public E remove() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            E returnData = queue[front];
            front = (front + 1) % capacity;
            size--;
            return returnData;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new CircIterator();
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray(Object[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == capacity) {
            reallocate();
        }

        size++;
        rear = (rear + 1) % capacity;
        queue[rear] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }


    private class CircIterator implements Iterator<E> {
        private int index;
        private int count;
    

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = queue[index];
            index = (index + 1) % capacity;
            count++;
            return returnValue;
        }
        
    }
    
}
