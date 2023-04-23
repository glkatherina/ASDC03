public class MenuRecord {
    private String dishName;
    private double price;
    private double weight;
    private String type;
    private String category;

    public MenuRecord(String dishName, double price, double weight, String type, String category)
    {
        this.dishName = dishName;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.category = category;
    }

    public String getDishName()
    {
        return dishName;
    }

    public double getPrice()
    {
        return price;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getType()
    {
        return type;
    }

    public String getCategory()
    {
        return category;
    }
}
