package ruleengine.v2;

import java.util.*;

// Data class for an e-commerce order
class Order {
    private double total;
    private final boolean isPremiumMember;
    private final int itemCount;
    private final boolean isDuringSale;
    private double shippingCost;
    private final List<String> gifts = new ArrayList<>();
    private boolean isExpressShipping;

    public Order(double total, boolean isPremiumMember, int itemCount, boolean isDuringSale, double shippingCost) {
        this.total = total;
        this.isPremiumMember = isPremiumMember;
        this.itemCount = itemCount;
        this.isDuringSale = isDuringSale;
        this.shippingCost = shippingCost;
    }

    // Getters and setters
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public boolean isPremiumMember() { return isPremiumMember; }
    public int getItemCount() { return itemCount; }
    public boolean isDuringSale() { return isDuringSale; }
    public double getShippingCost() { return shippingCost; }
    public void setShippingCost(double shippingCost) { this.shippingCost = shippingCost; }
    public List<String> getGifts() { return gifts; }
    public boolean isExpressShipping() { return isExpressShipping; }
    public void setExpressShipping(boolean isExpressShipping) { this.isExpressShipping = isExpressShipping; }
}

// Interface for facts storage
interface FactsRepository {
    void put(String key, Object value);
    Object get(String key);
}

// In-memory facts repository
class InMemoryFactsRepository implements FactsRepository {
    private final Map<String, Object> facts = new HashMap<>();

    @Override
    public void put(String key, Object value) {
        facts.put(key, value);
    }

    @Override
    public Object get(String key) {
        return facts.get(key);
    }
}

// Rule interface
interface Rule {
    boolean evaluate(FactsRepository facts);
    void execute(FactsRepository facts);
    int getPriority();
    String getName();
}

// Abstract base rule for common functionality
abstract class BaseRule implements Rule {
    private final String name;
    private final int priority;

    protected BaseRule(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getPriority() { return priority; }
}

// Rule: 10% discount if total > $100
class DiscountRule extends BaseRule {
    public DiscountRule() {
        super("DiscountRule", 1);
    }

    @Override
    public boolean evaluate(FactsRepository facts) {
        Order order = (Order) facts.get("order");
        return order.getTotal() > 100;
    }

    @Override
    public void execute(FactsRepository facts) {
        Order order = (Order) facts.get("order");
        order.setTotal(order.getTotal() * 0.9);
    }
}

// Rule: Free shipping for premium members
class ShippingRule extends BaseRule {
    public ShippingRule() {
        super("ShippingRule", 2);
    }

    @Override
    public boolean evaluate(FactsRepository facts) {
        Order order = (Order) facts.get("order");
        return order.isPremiumMember();
    }

    @Override
    public void execute(FactsRepository facts) {
        Order order = (Order) facts.get("order");
        order.setShippingCost(0);
    }
}

// Composite rule: Groups multiple rules
class CompositeRule extends BaseRule {
    private final List<Rule> subRules = new ArrayList<>();

    public CompositeRule(String name, int priority) {
        super(name, priority);
    }

    public void addRule(Rule rule) {
        subRules.add(rule);
    }

    @Override
    public boolean evaluate(FactsRepository facts) {
        return subRules.stream().allMatch(rule -> rule.evaluate(facts));
    }

    @Override
    public void execute(FactsRepository facts) {
        for (Rule rule : subRules) {
            if (rule.evaluate(facts)) {
                rule.execute(facts);
            }
        }
    }
}

// Rule factory interface
interface RuleFactory {
    Rule createRule(String type);
}

// Concrete rule factory
class DefaultRuleFactory implements RuleFactory {
    @Override
    public Rule createRule(String type) {
        switch (type.toLowerCase()) {
            case "discount":
                return new DiscountRule();
            case "shipping":
                return new ShippingRule();
            case "premium":
                CompositeRule premiumRule = new CompositeRule("PremiumRule", 3);
                premiumRule.addRule(new DiscountRule());
                premiumRule.addRule(new ShippingRule());
                return premiumRule;
            default:
                throw new IllegalArgumentException("Unknown rule type: " + type);
        }
    }
}

// Execution strategy interface
interface ExecutionStrategy {
    void execute(List<Rule> rules, FactsRepository facts, RuleListener listener);
}

// Sequential execution strategy
class SequentialExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(List<Rule> rules, FactsRepository facts, RuleListener listener) {
        for (Rule rule : rules) {
            listener.onEvaluate(rule, facts);
            if (rule.evaluate(facts)) {
                rule.execute(facts);
                listener.onExecute(rule, facts);
            }
        }
    }
}

// Priority-based execution strategy
class PriorityExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(List<Rule> rules, FactsRepository facts, RuleListener listener) {
        rules.stream()
                .sorted(Comparator.comparingInt(Rule::getPriority))
                .forEach(rule -> {
                    listener.onEvaluate(rule, facts);
                    if (rule.evaluate(facts)) {
                        rule.execute(facts);
                        listener.onExecute(rule, facts);
                    }
                });
    }
}

// Rule listener interface for observing rule events
interface RuleListener {
    void onEvaluate(Rule rule, FactsRepository facts);
    void onExecute(Rule rule, FactsRepository facts);
}

// Simple logging listener
class LoggingRuleListener implements RuleListener {
    @Override
    public void onEvaluate(Rule rule, FactsRepository facts) {
        System.out.println("Evaluating rule: " + rule.getName());
    }

    @Override
    public void onExecute(Rule rule, FactsRepository facts) {
        System.out.println("Executed rule: " + rule.getName());
    }
}

// The modular rule engine
class ModularRuleEngine {
    private final List<Rule> rules = new ArrayList<>();
    private final RuleFactory ruleFactory;
    private final ExecutionStrategy executionStrategy;
    private final RuleListener listener;

    public ModularRuleEngine(RuleFactory ruleFactory, ExecutionStrategy executionStrategy, RuleListener listener) {
        this.ruleFactory = ruleFactory;
        this.executionStrategy = executionStrategy;
        this.listener = listener;
    }

    public void addRule(String ruleType) {
        rules.add(ruleFactory.createRule(ruleType));
    }

    public void run(FactsRepository facts) {
        executionStrategy.execute(rules, facts, listener);
    }
}

// Main class to demonstrate the modular rule engine
public class ModularRuleEngineDemo {
    public static void main(String[] args) {
        // Initialize components
        RuleFactory factory = new DefaultRuleFactory();
        ExecutionStrategy strategy = new PriorityExecutionStrategy();
        RuleListener listener = new LoggingRuleListener();
        FactsRepository facts = new InMemoryFactsRepository();

        // Create the engine
        ModularRuleEngine engine = new ModularRuleEngine(factory, strategy, listener);

        // Add rules
        engine.addRule("discount");
        engine.addRule("shipping");
        engine.addRule("premium");

        // Set up facts
        Order order = new Order(150.0, true, 6, true, 10.0);
        facts.put("order", order);

        // Run the engine
        engine.run(facts);

        // Display results
        System.out.println("Final total: $" + String.format("%.2f", order.getTotal()));
        System.out.println("Shipping cost: $" + String.format("%.2f", order.getShippingCost()));
        System.out.println("Gifts: " + order.getGifts());
        System.out.println("Express shipping: " + order.isExpressShipping());
    }
}
