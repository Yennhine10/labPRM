package SQLite;

public class Product {
    private String id;
    private String name;
    private String price;
    private int image;
    public Product() {
    }

    public Product(String price, String name, String id,int image) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
