import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuBinarySearchTree tree = new MenuBinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filename = scanner.nextLine();

        try {
            tree.readMenuFromFile(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return;
        }

        tree.inorderTraversal(tree.root);
        System.out.println();

        System.out.print("Введите название блюда, которое нужно удалить: ");
        String dishName = scanner.nextLine();
        tree.delete(dishName);

        tree.inorderTraversal(tree.root);
    }
}