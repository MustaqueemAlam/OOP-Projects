package mainpkg;

public class cartitem {
    private float Pricetextfield;
    private float PreDefVATtextfield;
    private String SelectproductCombobox;
    private int QuantityBox;
    private float costBoundTextFeild;
    private int vatConsiderComboBox;
    
    public cartitem(float Pricetextfield, float PreDefVATtextfield, String SelectproductCombobox, int QuantityBox){
        this.Pricetextfield=Pricetextfield;
        this.PreDefVATtextfield=PreDefVATtextfield;
        this.SelectproductCombobox=SelectproductCombobox;
        this.QuantityBox = QuantityBox;
        this.costBoundTextFeild=costBoundTextFeild;
        this.vatConsiderComboBox=vatConsiderComboBox;
    }
    public float getPrice() {
        return Pricetextfield;
    }
    
    public float getPreDefVAT() {
        return PreDefVATtextfield;
    }
    public String getProduct(){
        return SelectproductCombobox;
    }
    public int getQuantity(){
        return QuantityBox;
    }
    public float getMRPcost(){
        return costBoundTextFeild;
   }
    public int getVATPercentageToCosider(){
       return vatConsiderComboBox;
    }
} 