package ruleengine.v1;

public interface Rule {
    boolean evaluate(Facts facts);
    void execute(Facts facts);
}
