package systemdesign.designpattern.behavioral.observerpattern;

// Concrete observer: Customer
class Customer implements Observer {
    private String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productName, boolean isAvailable) {
        if (isAvailable) {
            System.out.println(customerName + ": The product '" + productName + "' is available now.");
        } else {
            System.out.println(customerName + ": The product '" + productName + "' is out of stock.");
        }
    }
}
