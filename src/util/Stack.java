package util;

import util.LinkedList;

public class Stack<E> extends LinkedList<E> {
    public Stack() {
        super();
    }

    public E peek() {
        return head.value;
    }

    public E pop() {
        if (empty()) return null;
        E value = head.value;
        head = head.next;
        length--;
        return value;
    }

    public boolean empty() {
        return length == 0;
    }
}