package com.company;

import java.util.Iterator;

class Node<E> {
    E value;
    Node next;

    public Node(E value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(E value) {
        this(value, null);
    }
}

public class LinkedList<E> implements Iterable<E> {
    Node<E> head;
    int length = 0;

    void add(E value) {
        head = new Node(value, head);
        length++;
    }

    E get(int n) throws IndexOutOfBoundsException {
        if (n >= length) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> node = this.head;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null && current.next != null;
            }

            @Override
            public E next() {
                current = current.next;
                return current.value;
            }
        };
    }
}