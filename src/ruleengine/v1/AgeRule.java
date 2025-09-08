package ruleengine.v1;

class AgeRule implements Rule {
    @Override
    public boolean evaluate(Facts facts) {
        Customer customer = (Customer) facts.get("customer");
        return customer.getAge() > 18;
    }

    @Override
    public void execute(Facts facts) {
        facts.put("canPurchaseAlcohol", true);
    }
}

