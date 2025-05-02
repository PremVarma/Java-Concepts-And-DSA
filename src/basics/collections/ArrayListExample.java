package basics.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ArrayListExample {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> numbers = new ArrayList(10);
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
//        numbers.set(0, 100); // replace element
//        numbers.add(9, 9);  // add at specified position
        Field field1 = ArrayList.class.getDeclaredField("elementData");
        field1.setAccessible(true);
        Object[] elementData1 = (Object[]) field1.get(numbers);
        System.out.println("List Size: " + numbers.size());
        System.out.println("Capacity: " + elementData1.length);
        numbers.add(10);
        numbers.add(10);
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(numbers);
        System.out.println("After resize List Size: " + numbers.size());
        System.out.println("After resize Capacity: " + elementData.length);


        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(1, 2, 4); // cannot add new element but replace existing
        List<Integer> list3 = List.of(1, 2, 3); // cannot add and replace element -> Unmodifiable List
    }
}
