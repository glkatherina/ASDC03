import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSearcher {
    public static List<Menu> searchMenu(String fileName, String query) throws FileNotFoundException
    {
        List<Menu> result = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.toLowerCase().contains(query.toLowerCase()))
            {
                String[] fields = line.split(",");
                Menu menu = new Menu(fields[0], Double.parseDouble(fields[1]),  Double.parseDouble(fields[2]), fields[3], fields[4]);
                result.add(menu);
            }
        }
        scanner.close();
        return result;
    }
}
