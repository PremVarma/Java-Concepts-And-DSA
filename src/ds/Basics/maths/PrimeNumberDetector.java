package ds.Basics.maths;

import java.util.Scanner;

public class PrimeNumberDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it's prime: ");

        // Input validation
        if (!scanner.hasNextLong()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.close();
            return;
        }

        long num = scanner.nextLong();
        scanner.close();

        if (num < 0) {
            System.out.println("Negative numbers cannot be prime.");
            return;
        }

        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    public static boolean isPrime(long n) {
        // Handle edge cases and small primes
        if (n <= 1) return false;
        if (n <= 3) return true;
        if ((n & 1) == 0 || n % 3 == 0) return false; // Check if even or divisible by 3

        // Check primes of the form 6k ± 1 up to sqrt(n)
        long sqrtN = (long) Math.sqrt(n);
        for (long i = 5; i <= sqrtN; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
