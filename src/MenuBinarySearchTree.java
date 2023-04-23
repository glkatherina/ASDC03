import java.util.Scanner;

public class MenuBinarySearchTree {
    public MenuTreeNode root;public MenuBinarySearchTree() {

        root = null;
        }

public void readMenuFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of menu items:");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
        System.out.println("Enter dish name, price, weight, type, and category separated by commas:");
        String line = scanner.nextLine();
        String[] fields = line.split(",");
        String dishName = fields[0];
        double price = Double.parseDouble(fields[1]);
        double weight = Double.parseDouble(fields[2]);
        String type = fields[3];
        String category = fields[4];
        MenuTreeNode node = new MenuTreeNode(dishName, price, weight, type, category);
        insert(node);
        }
        scanner.close();
        }

// остальные методы остаются без изменений


public void insert(MenuTreeNode node) {
        if (root == null) {
            root = node;
            return;
        }
        MenuTreeNode current = root;
        while (true) {
            if (node.dishName.compareTo(current.dishName) < 0) {
                if (current.left == null) {
                    current.left = node;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    return;
                }
                current = current.right;
            }
        }
    }

    public void inorderTraversal(MenuTreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.dishName + ", " + node.price + ", " + node.weight + ", " + node.type + ", " + node.category);
        inorderTraversal(node.right);
    }

    public void postorderTraversal(MenuTreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.dishName + ", " + node.price + ", " + node.weight + ", " + node.type + ", " + node.category);
    }

    public void preorderTraversal(MenuTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.dishName + ", " + node.price + ", " + node.weight + ", " + node.type + ", " + node.category);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public MenuTreeNode search(String dishName) {
        MenuTreeNode current = root;
        while (current != null) {
            if (current.dishName.equals(dishName)) {
                return current;
            } else if (dishName.compareTo(current.dishName) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void delete(String dishName) {
        root = deleteNode(root, dishName);
    }

    private MenuTreeNode deleteNode(MenuTreeNode node, String dishName) {
        if (node == null) {
            return null;
        }
        if (dishName.compareTo(node.dishName) < 0) {
            node.left = deleteNode(node.left, dishName);
        } else if (dishName.compareTo(node.dishName) > 0) {
            node.right = deleteNode(node.right, dishName);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                MenuTreeNode temp = findMin(node.right);
                node.dishName = temp.dishName;
                node.price = temp.price;
                node.weight = temp.weight;
                node.type = temp.type;
                node.category = temp.category;
                node.right = deleteNode(node.right, temp.dishName);
            }
        }
        return node;
    }

    private MenuTreeNode findMin(MenuTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
