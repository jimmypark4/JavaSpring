package hello.core.order;

public class Order {
    private  Long meberId;
    private  String itemName;
    private int itemPrice;
    private int dicountPrice;

    public int calculatePrice(){
        return itemPrice- dicountPrice;
    }
    @Override
    public String toString() {
        return "Order{" +
                "meberId=" + meberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", dicountPrince=" + dicountPrice +
                '}';
    }

    public Order(Long meberId, String itemName, int itemPrice, int dicountPrince) {
        this.meberId = meberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.dicountPrice = dicountPrince;
    }

    public Long getMeberId() {
        return meberId;
    }

    public void setMeberId(Long meberId) {
        this.meberId = meberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDicountPrice() {
        return dicountPrice;
    }

    public void setDicountPrice(int dicountPrice) {
        this.dicountPrice = dicountPrice;
    }

    public int getDiscountPrice() {
        return dicountPrice;
    }
}
