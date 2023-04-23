import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String filename = "D:\\УНИВЕР\\II курс\\ASDC\\Lab3\\src\\Menu.txt";
        try
        {
            List<Menu> menuList = MenuReader.readMenu(filename);
            MenuProcessor.printMenu(menuList);
            System.out.print("Введите название блюда, которое нужно удалить: ");
            String dishName = scanner.nextLine();

            MenuRemover.removeRecord(filename, dishName);

            System.out.println("Запись успешно удалена.");

            menuList = MenuReader.readMenu(filename);
            MenuProcessor.printMenu(menuList);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден.");
        }
        catch (IOException e)
        {
            System.out.println("Произошла ошибка при удалении записи: " + e.getMessage());
        }

        System.out.println("Введите запрос для поиска в меню (или нажмите Enter, чтобы пропустить):");
        String query = scanner.nextLine();
        if (!query.isEmpty())
        {
            try
            {
                List<Menu> result = MenuSearcher.searchMenu(filename, query);
                MenuProcessor.printMenu(result);
            } catch (FileNotFoundException e)
            {
                System.out.println("Файл не найден.");
            }
        }

        System.out.println("Вы хотите добавить новую запись в меню? (Y/N)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y"))
        {
            System.out.println("Введите название блюда:");
            String dishName = scanner.nextLine();
            System.out.println("Введите цену:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите массу:");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println("Введите тип:");
            String type = scanner.nextLine();
            System.out.println("Введите категорию:");
            String category = scanner.nextLine();
            MenuRecord menuRecord = new MenuRecord(dishName, price, weight, type, category);

            try
            {
                FileWriter fw = new FileWriter(filename, true);
                fw.write(menuRecord.getDishName() + "," + menuRecord.getPrice() + "," + menuRecord.getWeight() + "," + menuRecord.getType() + "," + menuRecord.getCategory() + "\n");
                fw.close();
                System.out.println("Запись успешно добавлена.");
            } catch (IOException e)
            {
                System.out.println("Произошла ошибка при вставке записи: " + e.getMessage());
            }
        }

        System.out.println("Вот обновленное меню:");
        try
        {
            List<Menu> menuList = MenuReader.readMenu(filename);
            MenuProcessor.printMenu(menuList);
        } catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден.");
        }
    }
}