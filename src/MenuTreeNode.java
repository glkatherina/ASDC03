public class MenuTreeNode {
    public String dishName;
    public double price;
    public double weight;
    public String type;
    public String category;
    public MenuTreeNode left;
    public MenuTreeNode right;

    public MenuTreeNode(String dishName, double price, double weight, String type, String category) {
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.category = category;
        this.left = null;
        this.right = null;
    }
}