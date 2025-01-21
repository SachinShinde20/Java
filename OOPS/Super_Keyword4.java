class Order {
    double basePrice;

    public Order(double basePrice) {
        this.basePrice = basePrice;
    }

    public double calculateTotalPrice() {
        return basePrice;
    }
}

class ExpressOrder extends Order {
    double expressFee;

    public ExpressOrder(double basePrice, double expressFee) {
        super(basePrice);
        this.expressFee = expressFee;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = super.calculateTotalPrice() + expressFee;
        System.out
                .println("Base Price: $" + basePrice + ", \tExpress Fee: $" + expressFee + ", \tTotal: $" + totalPrice);
        return totalPrice;
    }
}

class GiftOrder extends Order {
    double giftPackagingFee;

    public GiftOrder(double basePrice, double giftPackagingFee) {
        super(basePrice);
        this.giftPackagingFee = giftPackagingFee;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = super.calculateTotalPrice() + giftPackagingFee;
        System.out.println(
                "Base Price: $" + basePrice + ", \tGift Packaging Fee: $" + giftPackagingFee + ", \tTotal: $"
                        + totalPrice);
        return totalPrice;
    }
}

public class Super_Keyword4 {
    public static void main(String[] args) {

        Order expressOrder = new ExpressOrder(100, 15); // Base price: $100, Express fee: $15
        expressOrder.calculateTotalPrice();

        Order giftOrder = new GiftOrder(100, 10); // Base price: $100, Gift packaging fee: $10
        giftOrder.calculateTotalPrice();
    }
}
