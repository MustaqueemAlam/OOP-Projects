package mainpkg;

public class cartitem {
    private float Price;
    private float PreDefVAT;
    private String Selectproduct;
    private int Quantity;

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getPreDefVAT() {
        return PreDefVAT;
    }

    public void setPreDefVAT(float PreDefVAT) {
        this.PreDefVAT = PreDefVAT;
    }

    public String getSelectproduct() {
        return Selectproduct;
    }

    public void setSelectproduct(String Selectproduct) {
        this.Selectproduct = Selectproduct;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public cartitem(float Price, float PreDefVAT, String Selectproduct, int Quantity) {
        this.Price = Price;
        this.PreDefVAT = PreDefVAT;
        this.Selectproduct = Selectproduct;
        this.Quantity = Quantity;
    }




} 