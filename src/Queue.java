public class Queue<E> extends LinkedList<E> {
    private Node<E> tail;

    public Queue() {
        super();
        this.tail = null;
    }

    public E poll() {
        if (empty()) return null;
        E value = head.value;
        head = head.next;
        length--;
        return value;
    }

    @Override
    public void add(E value) {
        if (head == null) {
            head = new Node(value, null);
            tail = head;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
        length++;
    }

    public boolean empty() {
        return length == 0;
    }
}