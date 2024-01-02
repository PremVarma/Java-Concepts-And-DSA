package basics.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//  =========== CLASS REFLECTION ===============================
        Class<Eagle> eagleClass = Eagle.class;
        System.out.println(eagleClass.getName());
        System.out.println(Modifier.toString(eagleClass.getModifiers()));

//================METHOD REFLECTION==============================
        Method[] methods = eagleClass.getMethods(); // Return public methods of this as well as Object class
        Arrays.stream(methods).forEach(method -> {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Class name: " + method.getDeclaringClass());
            System.out.println("===============");
        });

//================METHOD REFLECTION FOR ALL PUBLIC AND PRIVATE ONLY FOR EAGLE CLASS NOT OBJECT==============================
        System.out.println("================METHOD REFLECTION FOR ALL PUBLIC AND PRIVATE ONLY FOR EAGLE CLASS NOT OBJECT CLASS==============================");
        Method[] allMethod = eagleClass.getDeclaredMethods(); // Return public and private of this class
        Arrays.stream(allMethod).forEach(method -> {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Class name: " + method.getDeclaringClass());
            System.out.println("===============");
        });

//================INVOKING METHOD USING REFLECTION==============================
        System.out.println("================INVOKING METHOD USING REFLECTION==============================");
        Eagle eagleObject = eagleClass.getDeclaredConstructor().newInstance(); // return object of class
        Method flyMethod = eagleClass.getMethod("fly", int.class, String.class);
        flyMethod.invoke(eagleObject, 10, "Hello Prem");

//================REFLECTION OF FIELD USING REFLECTION==============================
        System.out.println("================REFLECTION OF FIELD USING REFLECTION==============================");
        Field[] fields = eagleClass.getFields(); // public fields
        Field[] allFields = eagleClass.getDeclaredFields(); // all field of class
        Arrays.stream(allFields).forEach(field -> {
            System.out.println("Method name: " + field.getName());
            System.out.println("Return type: " + field.getType());
            System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("===============");
        });

//================SETTING VALUE OF PUBLIC FIELD==============================
        System.out.println("================SETTING VALUE OF PUBLIC FIELD==============================");
        Field breedField = eagleClass.getDeclaredField("breed");
        breedField.set(eagleObject, "eagleBrownBreed");
        System.out.println(eagleObject.breed);
        System.out.println("================SETTING VALUE OF PRIVATE FIELD==============================");
        Field swimField = eagleClass.getDeclaredField("swim");
        swimField.setAccessible(true);
        swimField.set(eagleObject, true);
        if (swimField.getBoolean(eagleObject)) {
            System.out.println("value is true");
        }

//================SINGLETON BREAK WITH CONSTRUCTOR REFLECTION==============================
        System.out.println("================SINGLETON BREAK WITH CONSTRUCTOR REFLECTION==============================");
        Constructor[] constructors = eagleClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Modifier: " + Modifier.toString(constructor.getModifiers()));
            constructor.setAccessible(true);
            Eagle object = (Eagle) constructor.newInstance();
            object.fly();
        }
    }
}
