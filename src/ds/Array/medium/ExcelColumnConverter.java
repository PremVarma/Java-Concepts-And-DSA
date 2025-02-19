package ds.Array.medium;

public class ExcelColumnConverter {
    public static void main(String[] args) {
        // Test cases
        int number1 = 1;     // Should return "A"
        int number26 = 26;   // Should return "Z"
        int number27 = 27;   // Should return "AA"
        int number702 = 702; // Should return "ZZ"
        int number703 = 703; // Should return "AAA"

        System.out.println("Column for " + number1 + ": " + numberToColumn(number1));
        System.out.println("Column for " + number26 + ": " + numberToColumn(number26));
        System.out.println("Column for " + number27 + ": " + numberToColumn(number27));
        System.out.println("Column for " + number702 + ": " + numberToColumn(number702));
        System.out.println("Column for " + number703 + ": " + numberToColumn(number703));
    }

    public static String numberToColumn(int number) {
        StringBuilder columnName = new StringBuilder();
        while (number > 0) {
            number--; // Adjust 0 Based Indexing
            int remainder = number % 26;
            char columnChar = (char) (remainder + 'A');
            columnName.insert(0, columnChar);
            number = number / 26;
        }
        return columnName.toString();
    }
}
