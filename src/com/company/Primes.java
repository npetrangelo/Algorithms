package com.company;

import java.util.Iterator;
import java.util.Scanner;

public class Primes {
    static LinkedList2<Integer> primes = new LinkedList2<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int prime : primes) {
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}

class Node2<E> {
    E value;
    Node next;

    public Node2(E value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node2(E value) {
        this(value, null);
    }
}

class LinkedList2<E> implements Iterable<E> {
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
