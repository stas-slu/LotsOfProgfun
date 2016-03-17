package javastuff.trees;

public class MaximumHeight {

    public static void main(String[] argc) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(8);
        tree.insert(4);
        tree.insert(9);
        tree.insert(2);
        tree.insert(0);
        tree.insert(3);

        System.out.println("Number of nodes: " + tree.countNodes());
        System.out.print("\nPost order : ");
        tree.postorder();
        System.out.print("\nPre order : ");
        tree.preorder();
        System.out.print("\nIn order : ");
        tree.inorder();
        System.out.print("\nMax height : ");
        tree.maxHeight();
    }
}

class Node{

    Node left, right;
    int data;

    public Node() {
        left = null;
        right = null;
        data = 0;
    }

    public Node(int n) {
        left = null;
        right = null;
        data = n;
    }

    public void setLeft(Node n){
        left = n;
    }

    public void setRight(Node n) {
        right = n;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}

class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) { /* Function to insert data recursively */
        if (node == null)
            node = new Node(data);
        else {
            if (node.getRight() == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    public int countNodes() { /* Function to count number of nodes */
        return countNodes(root);
    }

    private int countNodes(Node r) {  /* Function to count number of nodes recursively */
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }

    public boolean search(int val) { /* Function to search for an element */
        return search(root, val);
    }

    private boolean search(Node r, int val) { /* Function to search for an element recursively */
        if (r.getData() == val)
            return true;
        if (r.getLeft() != null)
            if (search(r.getLeft(), val))
                return true;
        if (r.getRight() != null)
            if (search(r.getRight(), val))
                return true;
        return false;
    }

    public void inorder() { /* Function for inorder traversal */
        inorder(root);
    }

    private void inorder(Node r) {
        if (r != null) {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }

    public void preorder() { /* Function for preorder traversal */
        preorder(root);
    }

    private void preorder(Node r) {
        if (r != null) {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }

    public void postorder() {  /* Function for postorder traversal */
        postorder(root);
    }

    private void postorder(Node r) {
        if (r != null) {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }

    public void maxHeight() {
        int maxHeight = maxHeight(root);
        System.out.println("Max height: " + maxHeight);
    }

    private int maxHeight(Node node) {
        if(node == null) {
            return 0;
        }

        return 1 + Math.max(maxHeight(node.getLeft()), maxHeight(node.getLeft()));
    }
}
