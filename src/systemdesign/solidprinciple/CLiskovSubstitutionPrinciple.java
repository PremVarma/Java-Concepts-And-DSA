package systemdesign.solidprinciple;

//Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program
public class CLiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();
    }
}

class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Sparrow extends Bird {

}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly...");
    }
}
