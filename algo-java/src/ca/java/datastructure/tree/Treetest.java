package ca.java.datastructure.tree;

public class Treetest {

    public static void main(String[] args) {
        BasicBinaryTree<Integer> root = new BasicBinaryTree();

        root.add(10);
        root.add(5);
        root.add(13);
        root.add(3);
        root.add(1);
        root.add(11);

        root.inOrderPrint(root.getRoot());

    }
}
