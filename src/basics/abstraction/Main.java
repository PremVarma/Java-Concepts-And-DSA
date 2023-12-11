package basics.abstraction;

// Abstract class representing a bank account
abstract class BankAccount<T> {
    private String accountNumber;
    private T balance;
    private Customer customer;

    public BankAccount(String accountNumber, T balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public T getBalance() {
        return balance;
    }

    public void deposit(T amount) {
        // Perform deposit logic here
        balance = addToBalance(balance, amount);
    }

    public void withdraw(T amount) {
        // Perform withdrawal logic here
        balance = subtractFromBalance(balance, amount);
    }

    public abstract T addToBalance(T balance, T amount);

    public abstract T subtractFromBalance(T balance, T amount);
}

// Concrete class representing a Savings Account
class SavingsAccount extends BankAccount<Double> {
    public SavingsAccount(String accountNumber, Double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public Double addToBalance(Double balance, Double amount) {
        return balance + amount;
    }

    @Override
    public Double subtractFromBalance(Double balance, Double amount) {
        return balance - amount;
    }
}

// Concrete class representing a Checking Account
class CheckingAccount extends BankAccount<Double> {
    public CheckingAccount(String accountNumber, Double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public Double addToBalance(Double balance, Double amount) {
        return balance + amount;
    }

    @Override
    public Double subtractFromBalance(Double balance, Double amount) {
        return balance - amount;
    }
}

class Transaction<T> {
    private BankAccount<T> source;
    private BankAccount<T> destination;
    private T amount;

    public Transaction(BankAccount<T> source, BankAccount<T> destination, T amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    public void execute() {
        // Perform transaction logic here
        source.withdraw(amount);
        destination.deposit(amount);
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        BankAccount<Double> savingsAccount = new SavingsAccount("SA123", 1000.0, customer1);
        BankAccount<Double> checkingAccount = new CheckingAccount("CA456", 500.0, customer2);

        Transaction<Double> transfer = new Transaction<>(savingsAccount, checkingAccount, 200.0);
        transfer.execute();

        System.out.println(customer1.getName() + "'s Savings Account Balance: $" + savingsAccount.getBalance());
        System.out.println(customer2.getName() + "'s Checking Account Balance: $" + checkingAccount.getBalance());
    }
}

