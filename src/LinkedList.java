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
    private Node<E> head;
    private Node<E> tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static LinkedList shallowCopyOf(LinkedList l) {
        LinkedList copy = new LinkedList();
        copy.length = l.length;
        copy.head = l.head;
        copy.tail = l.tail;
        return copy;
    }

    public int length() {
        return this.length;
    }

    public void add(E value) {
        head = new Node(value, head);
        length++;
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

    public void qAdd(E value) {
        if (head == null) {
            head = new Node(value, null);
            tail = head;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
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

    public boolean empty() {
        return length == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (E item : this) {
            sb.insert(1, item.toString() + ",");
        }
        sb.append("]");
        return sb.toString();
    }
}