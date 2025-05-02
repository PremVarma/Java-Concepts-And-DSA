package basics.oops;

public interface Legacy {
    default void running() {
        System.out.println("I am running");
    }

    void flying();

    public static void main(String[] args) {
        Legacy legacy = new LegacyImpl();
        legacy.flying();
        legacy.running();

        Legacy legacy1 = new LegacyImpl2();
        legacy1.flying();
        legacy1.running();
    }
}

class LegacyImpl implements Legacy {
    @Override
    public void running() {
        System.out.println("I am here");
    }

    @Override
    public void flying() {
        System.out.println("Legacy Flying");
    }
}

class LegacyImpl2 implements Legacy {

    @Override
    public void flying() {
        System.out.println("Hahaha");
    }
}
