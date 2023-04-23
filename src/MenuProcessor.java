import java.util.List;

public class MenuProcessor {
    public static void printMenu(List<Menu> menuList)
    {
        for (Menu menu : menuList)
        {
            System.out.println( menu.getName() + ", " +
                menu.getPrice() + ", " +
                menu.getWeight() + ", " +
                menu.getType() + ", " +
                menu.getKind());
        }
    }
}
