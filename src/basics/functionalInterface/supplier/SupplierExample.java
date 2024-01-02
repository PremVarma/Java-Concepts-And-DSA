package basics.functionalInterface.supplier;

import java.util.function.Supplier;

class PasswordGenerator {
    // Supplier for generating random passwords
    private final Supplier<String> passwordSupplier;

    public PasswordGenerator() {
        this.passwordSupplier = this::generateRandomPassword;
    }

    // Method to generate a random password
    private String generateRandomPassword() {
        // Logic for generating a random password (for illustration purposes)
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char randomChar = (char) ('A' + Math.random() * 26);
            password.append(randomChar);
        }
        return password.toString();
    }

    // Method to get a new random password using the Supplier
    public String generatePassword() {
        return passwordSupplier.get();
    }

}

class SupplierExample{
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        // Using the Supplier to generate passwords
        for (int i = 0; i < 5; i++) {
            String newPassword = passwordGenerator.generatePassword();
            System.out.println("Generated Password: " + newPassword);
        }
    }
}

