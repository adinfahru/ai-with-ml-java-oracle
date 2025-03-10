class Node {
    int data;
    Node left, right;

    // Constructor
    public Node(int item) {
        data = item;
        left = right = null;
    }

    // Inorder Traversal (Left, Root, Right)
    public void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    // Postorder Traversal (Left, Right, Root)
    public void printPostorder(Node node) {
        if (node != null) {
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // Preorder Traversal (Root, Left, Right)
    public void printPreorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }

    // Setter for left and right nodes
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class NodeDriver {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.setLeft(node2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setLeft(node7);
        root.setRight(node3);
        node3.setRight(node6);

        System.out.println("Inorder Traversal:");
        root.printInorder(root);
        System.out.println("\nPostorder Traversal:");
        root.printPostorder(root);
        System.out.println("\nPreorder Traversal:");
        root.printPreorder(root);
    }
}
