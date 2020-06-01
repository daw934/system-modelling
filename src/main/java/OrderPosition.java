public class OrderPosition {
    private String itemName;
    private float unitPrice;
    private int vat;
    private float quantity;

    public double grossValueCalculate(){
        double vatd = vat / 100.0;
        return quantity * (unitPrice + unitPrice * vatd);
    }
    public double TAXCalculate(){
        double vatd = vat / 100.0;
        return quantity*(unitPrice * vatd);
    }

    public OrderPosition(String itemName, float unitPrice, int vat, float quantity) {
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.vat = vat;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "itemName='" + itemName + '\'' +
                ", grossValue=" + grossValueCalculate() +
                ", tax=" + TAXCalculate() +
                '}';
    }
}
