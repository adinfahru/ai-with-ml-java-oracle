package Btree;

// Kelas Node untuk merepresentasikan setiap elemen dalam pohon biner
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public int getData() {
        return data;
    }
}

// Kelas BTree untuk merepresentasikan struktur pohon biner
class BTree {
    private Node root;
    private Node current;

    public BTree() {
        this.root = null;
        this.current = null;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setCurrent(Node node) {
        this.current = node;
    }

    public Node getCurrent() {
        return current;
    }

    // Menghitung jumlah node dalam pohon secara rekursif
    public int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }

    // Metode inorder traversal (Left -> Root -> Right)
    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.getData() + " ");
            printInOrderRecursive(node.right);
        }
    }

    // Metode preorder traversal (Root -> Left -> Right)
    public void printPreOrder() {
        printPreOrderRecursive(root);
    }

    private void printPreOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            printPreOrderRecursive(node.left);
            printPreOrderRecursive(node.right);
        }
    }

    // Metode postorder traversal (Left -> Right -> Root)
    public void printPostOrder() {
        printPostOrderRecursive(root);
    }

    private void printPostOrderRecursive(Node node) {
        if (node != null) {
            printPostOrderRecursive(node.left);
            printPostOrderRecursive(node.right);
            System.out.print(node.getData() + " ");
        }
    }

    // Metode untuk mencetak pohon secara hierarkis
    public void print() {
        printTree(root, 0);
    }

    private void printTree(Node node, int space) {
        int COUNT = 5;
        if (node == null)
            return;
        space += COUNT;
        printTree(node.right, space);
        System.out.println();
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.println(node.data);
        printTree(node.left, space);
    }
}

// Driver class untuk menjalankan program
public class TreeDriver {
    public static void main(String[] args) {
        System.out.println("Creating Tree");
        BTree tree = new BTree();

        System.out.println("Count nodes in empty tree");
        System.out.println(tree.countNodes());

        System.out.println("Create Nodes with data 1");
        Node root = new Node(1);
        System.out.println("Set node as root");
        tree.setRoot(root);

        System.out.println("Count nodes in tree with only root added");
        System.out.println(tree.countNodes());

        // Membuat node tambahan
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        // Menyusun pohon
        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node7);
        root.setRight(node3);
        node3.setRight(node6);

        System.out.println("Set the current node to be the root");
        tree.setCurrent(tree.getRoot());
        System.out.println("Display the current node");
        System.out.println(tree.getCurrent().getData());

        System.out.println("Count nodes in tree with 7 nodes added");
        System.out.println(tree.countNodes());

        System.out.println("In Order print");
        tree.printInOrder();
        System.out.println("\nPre order print");
        tree.printPreOrder();
        System.out.println("\nPost order print");
        tree.printPostOrder();
        System.out.println("\nDisplay the nodes as tree diagram");
        tree.print();
    }
}
