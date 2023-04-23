import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuReader {
    public static List<Menu> readMenu(String filename) throws FileNotFoundException
    {
        List<Menu> menuList = new ArrayList<>();

        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            String name = fields[0];
            double price = Double.parseDouble(fields[1]);
            double weight = Double.parseDouble(fields[2]);
            String type = fields[3];
            String kind = fields[4];
            Menu menu = new Menu(name, price, weight, type, kind);
            menuList.add(menu);
        }

        scanner.close();

        return menuList;
    }
}
