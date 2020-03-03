package ca.java.datastructure.tree;


public class BasicBinaryTree<T extends Comparable<T>> {

    private Node root;
    private int treeSize;

    public BasicBinaryTree() {
        this.root = null;
        this.treeSize = 0;
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return treeSize;
    }

    public void add(T item) {
        Node newNode = new Node(item);
        if (size() == 0) {
            this.root = newNode;
            this.treeSize++;
        }
        else {
            insert(this.root, newNode);
        }
    }

    public boolean contains(T item) {
        if (size() == 0) {
            return false;
        }
        else {
            return containHelper(this.root, item);
        }
    }

    public boolean delete(T item) {
        boolean deleted = false;
        if (size() == 0) {
            System.out.println("empty tree.");
            return deleted;
        }

        Node currentNode = getNode(item);

        if (currentNode != null) {
            if(currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
                unlink(currentNode, null);
                deleted = true;
            }
            else if (currentNode.getLeftNode() == null && currentNode.getRightNode() != null) {
                unlink(currentNode, currentNode.getRightNode());
                deleted = true;
            }
            else if (currentNode.getLeftNode() != null && currentNode.getRightNode() == null) {
                unlink(currentNode, currentNode.getLeftNode());
                deleted = true;
            }
            else {
                Node child = currentNode.getLeftNode();
                while (child.getRightNode() != null && child.getLeftNode() != null) {
                    child = child.getRightNode();
                }

                child.getParentNode().setRightNode(null);
                child.setLeftNode(currentNode.getLeftNode());
                child.setRightNode(currentNode.getRightNode());

                unlink(currentNode, child);
                deleted = true;
            }
        }
        return deleted;
    }

    public void inOrderPrint(Node node) {
        if (node != null) {
            inOrderPrint(node.getLeftNode());
            System.out.println(node.getVal() + ", ");
            inOrderPrint(node.getRightNode());
        }
    }

    private Node getNode(T item) {

        if (root == null) {
            return null;
        }

        Node currentNode = root;

        while (currentNode != null) {
            if (item.compareTo(currentNode.getVal()) == 0) {
                return currentNode;
            } else if (item.compareTo(currentNode.getVal()) < 0) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }

        return null;

    }

    private void unlink(Node node, Node newNode) {
        if (node == this.root) {
            newNode.setLeftNode(node.getLeftNode());
            newNode.setRightNode(node.getRightNode());
            this.root = newNode;
        } else if (node.getParentNode().getRightNode() == node){
            node.getParentNode().setRightNode(newNode);
        } else {
            node.getParentNode().setLeftNode(newNode);
        }

    }

    private boolean containHelper(Node node, T item) {
        if (node == null) {
            return false;
        }
        if (item.compareTo(node.getVal()) == 0) {
            return true;
        }
        else if (item.compareTo(node.getVal()) < 0) {
            // go deeper into the left
            return containHelper(node.getLeftNode(), item);
        }
        else {
            return containHelper(node.getRightNode(), item);
        }
    }

    private void insert(Node parent, Node child) {
        if (child.getVal().compareTo(parent.getVal()) < 0) {
            // goes to the left
            if (parent.getLeftNode() == null) {
                parent.setLeftNode(child);
                child.setParentNode(parent);
                this.treeSize++;
            }
            else {
                insert(parent.getLeftNode(), child);
            }
        }
        else if (child.getVal().compareTo(parent.getVal()) > 0) {
            if (parent.getRightNode() == null) {
                parent.setRightNode(child);
                child.setParentNode(parent);
                this.treeSize++;
            }
            else {
                insert(parent.getRightNode(), child);
            }
        }
        else {
            System.out.println("parent == child, duplicates are not allowed.");
        }
    }

    private class Node {
        private T val;
        private Node leftNode;
        private Node rightNode;
        private Node parentNode;

        public Node(T val) {
            this.val = val;
            this.leftNode = null;
            this.rightNode = null;
            this.parentNode = null;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public Node getParentNode() {
            return parentNode;
        }

        public void setParentNode(Node parentNode) {
            this.parentNode = parentNode;
        }
    }
}
