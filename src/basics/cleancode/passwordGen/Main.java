package basics.cleancode.passwordGen;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator =  new PasswordGenerator(6);
        System.out.println(passwordGenerator.generatePassword());
    }
}
