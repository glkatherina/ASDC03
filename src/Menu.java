public class Menu {
    private String name;
    private double price;
    private double weight;
    private String type;
    private String kind;

    public Menu(String name, double price, double weight, String type, String kind)
    {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.kind = kind;
    }

    public String getName()
    {
        return name;
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

    public String getKind()
    {
        return kind;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setKind(String kind)
    {
        this.kind = kind;
    }
}
