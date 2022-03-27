package com.dsadeghi.stackqueue;

import java.util.ArrayList;
import java.util.EmptyStackException;

import my.library.StackInterface;

public class ArrayListStack <E> implements StackInterface<E> {

    private ArrayList<E> stack = new ArrayList<E>();

    public int size() {
        return stack.size();
    }

    @Override
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }

        return stack.get(stack.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E push(E e) {
        stack.add(e);
        return e;
    }
    

}
