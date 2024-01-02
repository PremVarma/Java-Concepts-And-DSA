package basics.oops;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
//======================== SIMPLE ENUM PRINT NUMBER VALUES ========================
        Arrays.stream(Day.values()).forEach(day -> System.out.println(day.ordinal()));
//======================== SIMPLE ENUM PRINT VALUES ========================
        System.out.println("======================== SIMPLE ENUM PRINT VALUES========================");
        Arrays.stream(Day.values()).forEach(System.out::println);
//======================== SIMPLE ENUM PRINT VALUE-OF========================
        System.out.println("======================== SIMPLE ENUM PRINT VALUE-OF========================");
        Day day = Day.valueOf("MONDAY");
        System.out.println(day.name());
//======================== CUSTOM ENUM PRINT VALUE========================
        System.out.println("//======================== CUSTOM ENUM PRINT VALUE========================");
        System.out.println(EnumWithCustomValue.getEnumFromValue(5));
//==============METHOD OVERRIDING WITH ENUMS=====================
        System.out.println("//==============METHOD OVERRIDING WITH ENUMS=====================");
        EnumMethodOR  enumMethodOR = EnumMethodOR.SUNDAY;
        enumMethodOR.dummyMethod();
        enumMethodOR.reWriteMe();
        enumMethodOR.toLowerCase();

    }
}

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

//==============ENUM WITH CUSTOM VALUES=====================
enum EnumWithCustomValue {
    SUNDAY(1, "Sunday"),
    MONDAY(2, "Monday"),
    TUESDAY(3, "Tuesday");

    private int val;
    private String comment;

    EnumWithCustomValue(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static EnumWithCustomValue getEnumFromValue(int value) {
        for (EnumWithCustomValue enumWithCustomValue : EnumWithCustomValue.values()) {
            if (enumWithCustomValue.val == value) {
                return enumWithCustomValue;
            }
        }
        return null;
    }
}

//==============METHOD OVERRIDING WITH ENUMS, INTERFACE, ABSTRACTION=====================
interface MyInterface{
    public String toLowerCase();
}
enum EnumMethodOR implements MyInterface{
    SUNDAY{
        @Override
        public void dummyMethod(){
            System.out.println("I am sunday...");
        }

        @Override
        public void reWriteMe() {
            System.out.println("I rewritten to Sunday...");
        }
    },
    MONDAY {
        @Override
        public void reWriteMe() {
            System.out.println("I rewritten to Monday...");
        }
    },
    TUESDAY {
        @Override
        public void reWriteMe() {
            System.out.println("I rewritten to Tuesday...");
        }
    };

    @Override
    public String toLowerCase(){
        System.out.println(this.name().toLowerCase());
        return this.name().toLowerCase();
    }

    public void dummyMethod(){
        System.out.println("default dummy method");
    }

    public abstract void reWriteMe();
}

enum Singleton{
    INSTANCE;

    public void print(){
        System.out.println("Print");
    }
}