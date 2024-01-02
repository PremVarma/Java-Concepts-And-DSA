package basics.reflection;

public class Eagle {
    public String breed;
    private boolean swim;

    private Eagle(){

    }

    @Deprecated
    public void fly() {
        System.out.println("fly....");
    }

    public void fly(int intParam, String strParam) {
        System.out.println("fly.... intParam : " + intParam + " strParam: " + strParam);
    }

    private void eat() {
        System.out.println("eat....");
    }
}

