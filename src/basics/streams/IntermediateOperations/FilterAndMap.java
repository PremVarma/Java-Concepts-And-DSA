package basics.streams.IntermediateOperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterAndMap {
    public static void main(String[] args) {
        List<Map<String, Object>> dummyData = createDummyData();
        var pickUpCriteriaList = dummyData.stream().filter(FilterAndMap::shouldIncludeInResult)
                .map(person -> (String) person.get("pickupCriteria"))
                .toList();
        pickUpCriteriaList.forEach(System.out::println);
    }

    private static boolean shouldIncludeInResult(Map<String, Object> billingCriteria) {
        String invoiceCategoryIndicator = (String) billingCriteria.get("invoiceIndicator");
        String prePickupFilter = (String) billingCriteria.get("preData");
        return "U".equals(invoiceCategoryIndicator) || ("age".equals(prePickupFilter) && billingCriteria.get("age") != null && !billingCriteria.get("age").toString().trim().isEmpty());
    }

    private static List<Map<String, Object>> createDummyData() {
        List<Map<String, Object>> dummyData = new ArrayList<>();

        Map<String, Object> person1 = new HashMap<>();
        person1.put("name", "Alice");
        person1.put("pickupCriteria", "Test");
        person1.put("invoiceIndicator", "U");
        person1.put("age", 25);
        dummyData.add(person1);

        Map<String, Object> person2 = new HashMap<>();
        person2.put("name", "Bob");
        person2.put("invoiceIndicator", "X");
        person2.put("preData", "age");
        person2.put("pickupCriteria", "testAGain");
        person2.put("age", 30);
        dummyData.add(person2);

        Map<String, Object> person3 = new HashMap<>();
        person3.put("name", "Charlie");
        person3.put("preData", "age");
        person3.put("pickupCriteria", "NoTest");
        person3.put("invoiceIndicator", "X");
        person3.put("age", "   ");
        dummyData.add(person3);

        return dummyData;
    }
}
