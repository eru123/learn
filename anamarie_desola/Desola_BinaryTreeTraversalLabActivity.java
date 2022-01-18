import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Desola_BinaryTreeTraversalLabActivity {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert("D");        
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("T");
        tree.insert("S");
        tree.insert("E");
        
        System.out.print("Tree = ");
        tree.print();
        System.out.print("\n\nPreOrder Traversal: ");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.print("InOrder Traversal: ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.print("PostOrder Traversal: ");
        tree.postOrder(tree.root);
        System.out.println();
        System.out.print("LevelOrder Traversal: ");
        tree.levelOrder(tree.root);
        System.out.println();
    }
}

class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

class BinaryTree {
    Node<String> root = null;
    final static Scanner sc = new Scanner(System.in);

    public void insert(String data) {
        if (root == null) {
            root = new Node<String>(data);
        } else {
            Node<String> current = root;
            Node<String> parent = null;
            while (true) {
                parent = current;
                if (data.compareTo(current.data) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node<String>(data);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node<String>(data);
                        return;
                    }
                }
            }
        }
    }

    // pre order traversal
    public void preOrder(Node<String> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // in order traversal
    public void inOrder(Node<String> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // post order traversal
    public void postOrder(Node<String> node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // level order traversal
    public void levelOrder(Node<String> node) {
        List<Node<String>> queue = new ArrayList<Node<String>>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node<String> current = queue.remove(0);
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // traversal
    public String print(Node<String> node) {
        String res = "";
        if (node != null) {
            res += node.data + ", ";
            res += print(node.left);
            res += print(node.right);
        }
        return res;
    }

    public void print() {
        String tree = print(root);
        System.out.print("[" + tree.substring(0,tree.length()-2) + "]");
    }
}