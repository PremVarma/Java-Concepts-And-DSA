package systemdesign.designpattern.behavioral.TemplateDesignPattern;

import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

// Abstract class for order validation
abstract class OrderValidationComponent {
    abstract void validateOrder();
}

// Abstract class for payment processing
abstract class PaymentProcessingComponent {
    abstract void processPayment();
}

// Abstract class for order confirmation
abstract class OrderConfirmationComponent {
    abstract void sendOrderConfirmation();
}

// Abstract class for the collective order processing components
abstract class OrderProcessingExecutor {
    private final ExecutorService executorService;

    OrderProcessingExecutor(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }

    // Abstract method for order validation
    abstract void validateOrder();

    // Abstract method for payment processing
    abstract void processPayment();

    // Abstract method for order confirmation
    abstract void sendOrderConfirmation();

    final void executeOrderProcessing() {
        validateOrder();
        processPayment();
        sendOrderConfirmation();
    }

    final void shutdownExecutorService() {
        executorService.shutdown();
    }

    final void submitOrderProcessing() {
        executorService.submit(this::executeOrderProcessing);
    }
}

// Concrete implementation of OrderValidationComponent
class ConcreteOrderValidator extends OrderValidationComponent {
    @Override
    void validateOrder() {
        System.out.println("Validating order...");
    }
}

// Concrete implementation of PaymentProcessingComponent
class ConcretePaymentProcessor extends PaymentProcessingComponent {
    @Override
    void processPayment() {
        System.out.println("Processing payment...");
    }
}

// Concrete implementation of OrderConfirmationComponent
class ConcreteOrderConfirmer extends OrderConfirmationComponent {
    @Override
    void sendOrderConfirmation() {
        System.out.println("Sending order confirmation...");
    }
}

// Concrete implementation of OrderProcessingExecutor
class ConcreteOrderProcessingExecutor extends OrderProcessingExecutor {
    ConcreteOrderProcessingExecutor(int numThreads) {
        super(numThreads);
    }

    @Override
    void validateOrder() {
        new ConcreteOrderValidator().validateOrder();
    }

    @Override
    void processPayment() {
        new ConcretePaymentProcessor().processPayment();
    }

    @Override
    void sendOrderConfirmation() {
        new ConcreteOrderConfirmer().sendOrderConfirmation();
    }
}

public class PracticalExample {
    public static void main(String[] args) {
        // Create an instance of the concrete order processing executor with 3 threads
        ConcreteOrderProcessingExecutor orderProcessor = new ConcreteOrderProcessingExecutor(3);

        // Submit the execution to the executor service
        orderProcessor.submitOrderProcessing();

        // Shutdown the executor service when done
        orderProcessor.shutdownExecutorService();
    }
}
