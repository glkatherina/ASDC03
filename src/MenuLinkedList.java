import java.util.Scanner;

public class MenuLinkedList {
    private MenuNode head;
    private int size;
    public MenuLinkedList() {
        head = null;
        size = 0;
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
            double price =Double.parseDouble(fields[1]);
            int calories = Integer.parseInt(fields[2]);
            boolean isVegetarian = Boolean.parseBoolean(fields[3]);
            Dish dish = new Dish(dishName, price, calories, isVegetarian);
            return dish;
        }
    }
