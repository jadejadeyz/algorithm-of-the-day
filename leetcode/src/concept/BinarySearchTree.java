package concept;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class BinarySearchTree {
    class TreeNode {
        int key;
        TreeNode left, right, parent;

        public TreeNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        TreeNode node = new TreeNode(key);
        if (root == null) {
            root = node;
            return;
        }

        TreeNode parent = null;
        TreeNode current = root;
        while (current != null) {
            parent = current;
            if (current.key < key)
                current = current.right;
            else current = current.left;
        }
        node.parent = parent;
        if (parent.key < key)
            parent.right = node;
        else parent.left = node;
    }

    public String inorder() {
        if (root == null)
            return "";

        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        StringJoiner sj = new StringJoiner(",");
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            sj.add(String.valueOf(node.key));
            node = node.right;
        }

        return sj.toString();
    }

    public boolean contains(int key) {
        TreeNode cur = root;
        while (cur != null && cur.key != key) {
            if (cur.key > key)
                cur = cur.left;
            else cur = cur.right;
        }
        return cur != null;
    }

    public TreeNode get(int key) {
        TreeNode cur = root;
        while (cur != null && cur.key != key)
            cur = cur.key > key? cur.left: cur.right;

        return cur;
    }

    public int min() {
        TreeNode cur = root;
        while (cur.left != null)
            cur = cur.left;

        return cur != null? cur.key: null;
    }

    public int min(TreeNode node) {
        TreeNode cur = node;
        while (cur.left != null)
            cur = cur.left;
        return cur != null? cur.key: -1;
    }

    public int successor(int key) {
        TreeNode node = get(key);
        if (node == null)
            return -1;

        if (node.right != null)
            return min(node.right);
        TreeNode ancestor = node.parent;
        while (ancestor != null && node != ancestor.left) {
            node = ancestor;
            ancestor = ancestor.parent;
        }

        return ancestor != null? ancestor.key: -1;
    }

    public int max() {
        TreeNode cur = root;
        while (cur.right != null)
            cur = cur.right;
        return cur != null? cur.key: null;
    }

    public int max(TreeNode node) {
        if (node == null)
            return -1;

        return max(node.right);
    }

    public int predecessor(int key) {
        TreeNode node = get(key);
        if (node == null)
            return -1;

        if (node.left != null)
            return max(node.left);
        TreeNode ancestor = node.parent;
        while (ancestor != null && node != ancestor.right) {
            node = ancestor;
            ancestor = ancestor.parent;
        }

        return ancestor != null? ancestor.key : -1;
    }
}
