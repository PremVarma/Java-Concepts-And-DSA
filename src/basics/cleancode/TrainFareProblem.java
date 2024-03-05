package basics.cleancode;

import java.util.Arrays;
import java.util.List;

//TODO: Extensible and Use Interfaces
enum TripType {
    SINGLE,
    RETURN
}

public class TrainFareProblem {
    private static final int BASE_PRICE = 50;
    private static final int PER_KM_PRICE = 3;
    private static final List<String> CITIES = Arrays.asList("delhi", "mumbai", "lucknow", "gujrat", "allahabad");

    public static void main(String[] args) {
        try {
            System.out.println(calculateOverallFare(CITIES.get(0), CITIES.get(0), TripType.RETURN));
        } catch (IllegalArgumentException e) {
            System.out.println("Error => " + e.getMessage());
        }
    }

    static double calculateDiscount(double totalFare) {
        return totalFare - (totalFare * 0.20);
    }

    static double calculateSingleTripFare(int distance) {
        if (distance > 1) return BASE_PRICE + ((distance - 1) * 100 * PER_KM_PRICE);
        return BASE_PRICE;
    }

    static double calculateRoundTripFare(int distance) {
        double totalFare;
        if (distance > 1) {
            totalFare = calculateSingleTripFare(distance) * 2;
        } else {
            totalFare = BASE_PRICE;
        }
        return calculateDiscount(totalFare);
    }

    static double calculateOverallFare(String source, String destination, TripType tripType) {
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();

        if (!CITIES.contains(lowerCaseSource) || !CITIES.contains(lowerCaseDestination)) {
            throw new IllegalArgumentException("Source or Destination is not found");
        }

        if (lowerCaseSource.equals(lowerCaseDestination)) {
            throw new IllegalArgumentException("Source and Destination cannot be the same");
        }

        int distance = Math.abs(CITIES.indexOf(lowerCaseDestination) - CITIES.indexOf(lowerCaseSource));
        if (tripType == TripType.SINGLE) return calculateSingleTripFare(distance);
        return calculateRoundTripFare(distance);
    }
}

