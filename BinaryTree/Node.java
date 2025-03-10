public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public void setLeft(Node node) {
        if (left == null)
            left = node;
    }

    public void setRight(Node node) {
        if (right == null)
            right = node;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create nodes
        Node root = new Node(10);
        Node leftChild = new Node(5);
        Node rightChild = new Node(15);

        // Set child nodes
        root.setLeft(leftChild);
        root.setRight(rightChild);

        // Print values
        System.out.println("Root: " + root.getData());
        System.out.println("Left Child: " + root.getLeft().getData());
        System.out.println("Right Child: " + root.getRight().getData());
    }
}
