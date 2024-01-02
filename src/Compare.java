
import java.util.ArrayList;
import java.util.List;

public class Compare {

    public static void main(String[] args) {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition(1, "Prem", ComparisonOperator.GREATER_THAN_INCLUSIVE, 300));
        conditions.add(new Condition(2, "Ramesh", ComparisonOperator.LESS_THAN_INCLUSIVE, 200));

        int amountToCheck = 290;
        List<Condition> filteredConditions = filterConditions(conditions, amountToCheck);

        System.out.println("Filtered:");
        for (Condition condition : filteredConditions) {
            System.out.println(condition);
        }
    }

    static List<Condition> filterConditions(List<Condition> conditions, int amount) {
        return conditions.stream()
                .filter(condition -> condition.matches(amount))
                .toList();
    }

    static class Condition {
        private final int id;
        private final String name;
        private final ComparisonOperator operator;
        private final int value;

        public Condition(int id, String name, ComparisonOperator operator, int value) {
            this.id = id;
            this.name = name;
            this.operator = operator;
            this.value = value;
        }

        public boolean matches(int amount) {
            return switch (operator) {
                case GREATER_THAN_INCLUSIVE -> amount >= value;
                case LESS_THAN_INCLUSIVE -> amount <= value;
                default -> true;
            };
        }

        @Override
        public String toString() {
            return String.format("{%d, %s, %s, %d}", id, name, operator, value);
        }
    }

    enum ComparisonOperator {
        GREATER_THAN_INCLUSIVE,
        LESS_THAN_INCLUSIVE,
    }
}