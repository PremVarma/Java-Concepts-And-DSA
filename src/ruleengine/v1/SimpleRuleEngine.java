package ruleengine.v1;

public class SimpleRuleEngine {
    public static void main(String[] args) {
        // Set up the engine and facts
        RuleEngine engine = new RuleEngine();
        Facts facts = new Facts();
        Customer customer = new Customer(19);
        facts.put("customer", customer);

        // Add the rule
        engine.addRule(new AgeRule());

        // Run the engine
        engine.run(facts);

        // Check the result
        Boolean canPurchase = (Boolean) facts.get("canPurchaseAlcohol");
        System.out.println("Can purchase alcohol? " + (canPurchase != null && canPurchase));
    }
}
