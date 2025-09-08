package ruleengine.v1;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private final List<Rule> rules = new ArrayList<>();

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void run(Facts facts) {
        for (Rule rule : rules) {
            if (rule.evaluate(facts)) {
                rule.execute(facts);
            }
        }
    }
}
