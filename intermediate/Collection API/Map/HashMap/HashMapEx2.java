import java.util.*;

class Order {
    String order;
    int quantity;
    int price;

    public Order(String order, int quantity, int price) {
        this.order = order;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order = " + order + ", Quantity = " + quantity + ", Price = " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order1 = (Order) o;
        return quantity == order1.quantity && price == order1.price && Objects.equals(order, order1.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, quantity, price);
    }
}

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<Integer, Order> hashMap = new HashMap<>();

        // Adding Order objects to the HashMap
        hashMap.put(1001, new Order("Coffee", 2, 15));
        hashMap.put(1002, new Order("Tea", 3, 12));
        hashMap.put(1003, new Order("Sandwich", 3, 15));
        hashMap.put(1004, new Order("Salad", 2, 20));
        hashMap.put(1005, new Order("Cake", 1, 35));
        hashMap.put(1006, new Order("Juice", 2, 20));
        hashMap.put(1007, new Order("Samosa", 1, 17));
        hashMap.put(null, null); // Adding a null key for testing removal

        // Printing the HashMap using forEach
        System.out.println("\nUsing forEach");
        hashMap.forEach((k, v) -> System.out.println("Key: " + k + ", \tValue: " + v));

        // Checking HashMap properties
        System.out.println("\nIs HashMap empty? " + hashMap.isEmpty());
        System.out.println("Size of HashMap: " + hashMap.size());
        System.out.println("Values in HashMap: " + hashMap.values());
        System.out.println("Keys in HashMap: " + hashMap.keySet());

        // Checking for specific keys and values
        System.out.println("\nDoes HashMap contain key 1005? " + hashMap.containsKey(1005));
        System.out.println("Does HashMap contain value 'Samosa'? " + hashMap.containsValue(new Order("Samosa", 1, 17)));

        // Getting value associated with a key
        System.out.println("Value for key 1003: " + hashMap.get(1003));



        // Iterating Map Using Advanced ForLoop
        System.out.println("\nIterating Map Using Advanced ForLoop");
        Set<Map.Entry<Integer, Order>> set = hashMap.entrySet();
        for (Map.Entry<Integer, Order> record: set){
            if (record.getKey()==null){
                record.setValue(new Order(" - ", 0, 0));
            }
            System.out.println("Key: " + record.getKey() + ", \tValue: " + record.getValue());
        }

        /*
        Why is modifying set affecting hashMap?
        Since entrySet() provides a view (reference) of the actual map, any modifications made to the elements of set directly reflect on the original hashMap.
        This means that if we modify a Map.Entry from the set, we are actually modifying the corresponding entry inside HashMap.
         */
        System.out.println("\nAfter Modification: " + hashMap);



        // Using Iterator to remove null key
        System.out.println("\nUsing Iterator");
        Iterator<Map.Entry<Integer, Order>> it = hashMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer, Order> record = it.next();
            if (record.getKey()==null){
                it.remove();
                continue; //Skip This Iteration
            }
            System.out.println("Key: " + record.getKey() + ", \tValue: " + record.getValue());
        }

        // Printing HashMap after removal of null key
        System.out.println("\nAfter removal: " + hashMap);
    }
}