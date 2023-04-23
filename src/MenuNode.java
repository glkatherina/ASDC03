public class MenuNode {
    public String dishName;
    public double price;
    public double weight;
    public String type;
    public String category;
    public MenuNode next;

    public MenuNode(String dishName, double price, double weight, String type, String category) {
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.category = category;
        this.next = null;
    }
}