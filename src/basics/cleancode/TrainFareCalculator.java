package basics.cleancode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

interface FareCalculator {
    double calculateFare(int distance);
}

class FareException extends RuntimeException {
    FareException(String message) {
        super(message);
    }
}

class SingleTripFareCalculator implements FareCalculator {
    private static final int BASE_PRICE = 50;
    private static final int PER_KM_PRICE = 3;
    private static final double DISTANCE_WITH_BASE_PRICE = 100;

    @Override
    public double calculateFare(int distance) {
        if (distance > DISTANCE_WITH_BASE_PRICE) {
            return BASE_PRICE + ((distance - BASE_PRICE) * PER_KM_PRICE);
        }
        return BASE_PRICE;
    }
}

class RoundTripFareCalculator implements FareCalculator {
    private static final double DISCOUNT_PERCENTAGE = 0.20;
    private final FareCalculator singleTripFareCalculator;

    RoundTripFareCalculator(FareCalculator singleTripFareCalculator) {
        this.singleTripFareCalculator = singleTripFareCalculator;
    }

    @Override
    public double calculateFare(int distance) {
        double totalFare = singleTripFareCalculator.calculateFare(distance) * 2;
        return totalFare - (totalFare * DISCOUNT_PERCENTAGE);
    }
}

class TrainFareCalculator {
    private static final Map<String, Integer> DISTANCES = new LinkedHashMap<>();

    static {
        DISTANCES.put("delhi", 0);
        DISTANCES.put("mumbai", 50);
        DISTANCES.put("lucknow", 100);
        DISTANCES.put("gujrat", 150);
        DISTANCES.put("allahabad", 200);
    }

    static double calculateOverallFare(String source, String destination, FareCalculator fareCalculator) {
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();

        if (!DISTANCES.containsKey(lowerCaseSource) || !DISTANCES.containsKey(lowerCaseDestination)) {
            throw new FareException("Source or Destination is not found");
        }

        if (lowerCaseSource.equals(lowerCaseDestination)) {
            throw new FareException("Source and Destination cannot be the same");
        }

        int distance = Math.abs(DISTANCES.get(lowerCaseDestination) - DISTANCES.get(lowerCaseSource));
        return fareCalculator.calculateFare(distance);
    }

    public static void main(String[] args) {
        try {
            FareCalculator singleTripFareCalculator = new SingleTripFareCalculator();
            FareCalculator roundTripFareCalculator = new RoundTripFareCalculator(singleTripFareCalculator);

            System.out.println(calculateOverallFare("delhi", "allahabad", roundTripFareCalculator));
        } catch (FareException e) {
            System.out.println("Error => " + e.getMessage());
        }
    }
}

