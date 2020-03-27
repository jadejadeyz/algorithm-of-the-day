package ca.algo.linkedlist;

public class JadeLinkedList<T> {
    // node that represents head node
    private Node<T> head;

    // register the current tail of the node
    private Node<T> tail;

    // no arg constructor
    public JadeLinkedList() {
        head = null;
        tail = null;
    }

    private JadeLinkedList(T data) {
        head = new Node(data);
        tail = head;
    }

    // construct with a head
    public JadeLinkedList(Node<T> head) {
        this.head = head;
        tail = this.head;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            Node<T> newNode = new Node<>(data);
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void addFirst(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        }
        Node<T> newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void remove(T data) {
        // removing a node involves search from the start
        Node<T> cur = head;
        if (head.data == data) {
            head = head.next;
        }
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.data == data) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }

    }

    public void removeTail() {
        Node<T> cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }

        cur.next = null;
        tail = cur;
    }

    public int length() {
        Node curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr.next != null) {
            sb.append(curr.data);
            sb.append(", ");
            curr = curr.next;
        }

        sb.append(curr.data);
        return sb.toString();
    }
}
