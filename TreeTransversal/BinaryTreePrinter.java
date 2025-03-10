package tree;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreePrinter {
    // Metode untuk mencetak pohon dalam format khusus
    private static void printTree(Node root, String prefix) {
        if (root == null)
            return;

        // Cetak node saat ini dengan prefix untuk format tertentu
        System.out.println(prefix + root.data);

        // Jika ada anak kiri, cetak tanpa spasi tambahan (agar menempel)
        if (root.left != null)
            printTree(root.left, "");

        // Jika ada anak kanan, cetak dengan prefix spasi tambahan
        if (root.right != null)
            printTree(root.right, " ");
    }

    public static void main(String[] args) {
        // Contoh pembuatan pohon
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);

        // Cetak pohon
        printTree(root, " ");
    }
}
