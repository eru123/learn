import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalLabActivity2 {
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

        int action = 0;

        while (action != 5){
            System.out.println("\nMenu");
            System.out.println("1. Pre-order");
            System.out.println("2. In-order");
            System.out.println("3. Post-order");
            System.out.println("4. Level-order");
            System.out.println("5. Terminate");
            
            System.out.print("\nEnter your choice: ");
            action = input.nextInt();
            
            switch (action){
                case 1:
                    System.out.print("PreOrder Traversal: ");
                    tree.preOrder(tree.root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("InOrder Traversal: ");
                    tree.inOrder(tree.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("PostOrder Traversal: ");
                    tree.postOrder(tree.root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("LevelOrder Traversal: ");
                    tree.levelOrder(tree.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Terminating...");
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }
        }

        // print tree 
        // System.out.print("Tree = ");
        // tree.print();
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