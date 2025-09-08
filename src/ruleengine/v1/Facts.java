package ruleengine.v1;

import java.util.HashMap;
import java.util.Map;

public class Facts {
    private final Map<String, Object> facts = new HashMap<>();

    public void put(String key, Object value) {
        facts.put(key, value);
    }

    public Object get(String key) {
        return facts.get(key);
    }
}
