package store.model;

public class Order {

    private final String orderId;
    private double totalPrice;

    public Order(String orderId){

        if (orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Invalid orderId!");
        }
        this.orderId = orderId;
        totalPrice = 0;
    }

    public String getOrderId(){
        return orderId;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public static class OrderItem{

        private final String productName;
        private final double unitPrice;
        private final int quantity;

        public OrderItem(String productName, double unitPrice, int quantity){

            if (productName == null || productName.isBlank()){
                throw new IllegalArgumentException("Invalid productName!");
            }

            if (!Double.isFinite(unitPrice) || unitPrice <= 0){
                throw new IllegalArgumentException("Invalid unitPrice!");
            }

            if (quantity <= 0){
                throw new IllegalArgumentException("Invalid quantity!");
            }

            this.productName = productName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public double calculateTotal(){

            double Price = unitPrice * quantity;

            if (!Double.isFinite(Price)){
                throw new IllegalArgumentException("Invalid total!");
            }
            return Price;
        }

        public void showInfo(){

            System.out.println("Product: " + productName);
            System.out.printf("Unit Price: %.1f%n" , unitPrice);
            System.out.println("Quantity: " + quantity);
            System.out.printf("Total: %.1f%n" , calculateTotal());
        }
    }

    public class Receipt{

        public void printReceipt(){

            System.out.println("Order ID: " + orderId);
            System.out.printf("Total Price: %.1f%n " , totalPrice);
        }
    }

    public void addItem(OrderItem item){

        if (item == null){
            throw new IllegalArgumentException("Invalid Item!");
        }

        double newTotalPrice = item.calculateTotal() + totalPrice;


        if (!Double.isFinite(newTotalPrice)){
            throw new IllegalArgumentException("Invalid Total");
        }
        totalPrice = newTotalPrice;
    }
}
