public class InvoiceItem {
    private final String id;
    private final String desc;
    private int qty;
    private double unitPrice;

    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        setQty(qty);             // ใช้ setter เพื่อผ่านเงื่อนไขตรวจค่า
        setUnitPrice(unitPrice); // ใช้ setter เพื่อผ่านเงื่อนไขตรวจค่า
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: " + qty);
        }
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative: " + unitPrice);
        }
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return qty * unitPrice;
    }

    @Override
    public String toString() {
        return "InvoiceItem[id=" + id + ", desc=" + desc + ", qty=" + qty + ", unitPrice=" + unitPrice + "]";
    }
}