package ca.java.datastructure.list;

public class BasicLinkedList<T> {
    private Node head, tail;
    private int nodeCount;

    private class Node {
        private T data;
        private Node nextNode;

        public Node(T data) {
            this.data = data;
            this.nextNode = null;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

        public T getData() {
            return this.data;
        }
    }

    public BasicLinkedList() {
        this.head = null;
        this.tail = null;
        this.nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node current = head;

        while (current != null) {
            contents.append(current.getData());
            current = current.getNextNode();

            if (current != null) {
                contents.append(", ");
            }
        }

        return contents.toString();
    }

    public void add(T newItem) {
        Node newNode = new Node(newItem);

        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        nodeCount++;
    }

    public void insert(T newItem, int index) {
        if (index > nodeCount) {
            throw new IllegalStateException("Exceed List Size");
        }
        else if (index == nodeCount){
            Node temp = new Node(newItem);
            tail.setNextNode(temp);
            tail = tail.getNextNode();
        }
        else if (index == 0) {
            Node temp = new Node(newItem);
            temp.setNextNode(head);
            head = temp;
        }
        else {
            Node temp = new Node(newItem);
            Node current = head;
            while (index > 1) {
                current = current.getNextNode();
                index--;
            }
            temp.setNextNode(current.getNextNode());
            current.setNextNode(temp);
        }
        nodeCount++;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        else {
            T headData = head.getData();
            head = head.getNextNode();
            nodeCount--;
            return headData;
        }
    }

    public T removeAt(int index) {
        if (index >= nodeCount) {
            throw new IllegalStateException("Linked List Overflow.");
        }
        else if (index == 0) {
            Node result = head;
            head = head.getNextNode();
            nodeCount--;
            return result.getData();
        }
        else if (index == nodeCount - 1) {
            Node result = tail;
            Node current = head;
            while (current.getNextNode() != tail) {
                current = current.getNextNode();
            }
            current.setNextNode(null);
            tail = current;
            nodeCount--;
            return result.getData();
        }
        else {
            Node result = null;
            Node current = head;
            while (index > 1) {
                current = current.getNextNode();
            }
            result = current.getNextNode();
            current.setNextNode(result.getNextNode());
            nodeCount--;
            return result.getData();
        }
    }

    public T get(int position) {
        if (head == null) {
            throw new IllegalStateException("empty list.");
        }

        Node currentNode = head;

        for (int i = 1; i < size() && currentNode != null; i++) {
            if (i == position) {
                return currentNode.getData();
            }
            currentNode = currentNode.getNextNode();
        }

        return null;
    }
}
