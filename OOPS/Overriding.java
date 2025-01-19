class Product {
    public String calculateDiscount() {
        return "Default discount applied: 10%";
    }
}

class Electronics extends Product {
    @Override
    public String calculateDiscount() {
        return "Discount on Electronics: 15%";
    }
}

class Clothing extends Product {
    @Override
    public String calculateDiscount() {
        return "Discount on Clothing: 22%";
    }
}

class Groceries extends Product {
    @Override
    public String calculateDiscount() {
        return "Discount on Groceries: 5%";
    }
}

public class Overriding {
    public static void main(String[] args) {
        Product[] productArr = {
                new Product(),
                new Electronics(),
                new Clothing(),
                new Groceries()
        };

        for (Product product : productArr) {
            System.out.println(product.calculateDiscount());
        }
    }
}
