package mainPackage;

import java.io.Serializable;

/*
 * @author tabriji
 */
public class CartItem implements Serializable {

    private String productName;
    private float unitPrice;
    private float vatRate;
    private int quantity;

    public CartItem(String productName, float unitPrice, float vatRate, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.vatRate = vatRate;
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public float getGrossTotal() {
        // calculating the gross total for this item based on the unitPrice and quantity
        float vatAmount = (unitPrice * quantity * vatRate) / 100;
        return (unitPrice * quantity) + vatAmount;
    }

    //getVatAmount() method
    public float getVatAmount() {
        return (unitPrice * quantity * vatRate) / 100;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getVatRate() {
        return vatRate;
    }

    public void setVatRate(float vatRate) {
        this.vatRate = vatRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productName=" + productName + ", unitPrice=" + unitPrice + ", vatRate=" + vatRate + ", quantity=" + quantity + '}';
    }

}
