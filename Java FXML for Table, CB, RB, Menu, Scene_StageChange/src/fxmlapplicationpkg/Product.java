package fxmlapplicationpkg;

public class Product {
    private int pId; private String name;
    private float price;

    public Product(int pId, String name, float price) {
        this.pId = pId;
        this.name = name;
        this.price = price;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "PID="+pId+", PName="+name+", Price="+price;
    }
}
