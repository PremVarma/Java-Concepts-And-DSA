package basics.cleancode.passwordGen;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class PasswordGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private final int length;
    private final Supplier<String> passwordSupplier;

    public PasswordGenerator(int length) {
        this.length = (length > 0) ? length : 6;
        this.passwordSupplier = this::generateStrongPassword;
    }

    private String generateStrongPassword() {
        List<Character> passwordCharacters = new ArrayList<>();

        // Add at least one character from each category
        passwordCharacters.add(getRandomChar(LOWERCASE_LETTERS));
        passwordCharacters.add(getRandomChar(UPPERCASE_LETTERS));
        passwordCharacters.add(getRandomChar(NUMBERS));
        passwordCharacters.add(getRandomChar(SPECIAL_CHARACTERS));

        // Add remaining characters
        for (int i = passwordCharacters.size(); i < length; i++) {
            String allCharacters = LOWERCASE_LETTERS + UPPERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;
            passwordCharacters.add(getRandomChar(allCharacters));
        }

        // Shuffle the characters to randomize the order
        Collections.shuffle(passwordCharacters);

        // Convert the List to a String
        StringBuilder password = new StringBuilder();
        for (char character : passwordCharacters) {
            password.append(character);
        }

        return password.toString();
    }

    private char getRandomChar(String characters) {
        int randomIndex = secureRandom.nextInt(characters.length());
        return characters.charAt(randomIndex);
    }

    public String generatePassword() {
        return passwordSupplier.get();
    }
}
