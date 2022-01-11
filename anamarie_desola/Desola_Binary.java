import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desola_Binary {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int action = 0;
        while (action != 4) {
            // show the menu (search, insert, display the tree and terminate the operation)
            System.out.println("\nMenu");
            System.out.println("1. Search");
            System.out.println("2. Insert");
            System.out.println("3. Display the tree");
            System.out.println("4. Terminate the operation");

            // get the user's choice
            System.out.print("\nEnter your choice: ");
            action = input.nextInt();

            // perform the action
            switch (action) {
                case 1:
                    tree.search();
                    break;
                case 2:
                    tree.insert();
                    break;
                case 3:
                    tree.display();
                    break;
                case 4:
                    tree.display();
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }
        }
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
    Node<Integer> root;
    final static Scanner sc = new Scanner(System.in);

    public BinaryTree() {
        root = null;
    }

    public void insert() {
        System.out.print("Enter the number to be inserted: ");
        int num = sc.nextInt();
        root = insert(root, num);
    }

    private Node<Integer> insert(Node<Integer> node, int data) {
        if (node == null) {
            node = new Node<Integer>(data);
            return node;
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void display() {
        BinaryTreePrinter.print(root);
    }

    public void search() {
        System.out.print("Enter the number to search: ");
        int data = sc.nextInt();

        if (search(root, data)) {
            System.out.println("Item Found in the Tree");
        } else {
            System.out.println("Item Not Found in the Tree");
        }
    }

    private boolean search(Node<Integer> node, int data) {
        if (node == null) {
            return false;
        }
        if (data < node.data) {
            return search(node.left, data);
        } else if (data > node.data) {
            return search(node.right, data);
        } else {
            return true;
        }
    }
}

class BinaryTreePrinter {

    public static <T extends Comparable<?>> void print(Node<T> root) {
        int maxLevel = BinaryTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinter.maxLevel(node.left), BinaryTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}