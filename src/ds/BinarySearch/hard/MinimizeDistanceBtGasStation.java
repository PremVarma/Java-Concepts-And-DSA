package ds.BinarySearch.hard;

import java.util.Objects;
import java.util.PriorityQueue;

public class MinimizeDistanceBtGasStation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println("Minimise distance is: " + minimiseMaxDistanceBF(arr, k));
        System.out.println("Minimise distance is: " + minimiseMaxDistance(arr, k));
    }


    public static double minimiseMaxDistanceBF(int[] arr, int k) {
        int n = arr.length; //size of array.
        int[] howMany = new int[n - 1];

        //Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            //Find the maximum section
            //and insert the gas station:
            double maxSection = -1;
            int maxInd = -1;
            for (int i = 0; i < n - 1; i++) {
                double diff = arr[i + 1] - arr[i];
                double sectionLength =
                        diff / (double)(howMany[i] + 1);
                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            //insert the current gas station:
            howMany[maxInd]++;
        }

        //Find the maximum distance i.e. the answer:
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++) {
            double diff = arr[i + 1] - arr[i];
            double sectionLength =
                    diff / (double)(howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }

    public static class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double minimiseMaxDistanceBT(int[] arr, int k) {
        int n = arr.length; // size of array.
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));

        // insert the first n-1 elements into pq
        // with respective distance values:
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        // Pick and place k gas stations:
        for (int gasStations = 1; gasStations <= k; gasStations++) {
            // Find the maximum section
            // and insert the gas station:
            Pair tp = pq.poll();
            int secInd = Objects.requireNonNull(tp).second;

            // insert the current gas station:
            howMany[secInd]++;

            double inidiff = arr[secInd + 1] - arr[secInd];
            double newSecLen = inidiff / (double) (howMany[secInd] + 1);
            pq.add(new Pair(newSecLen, secInd));
        }

        return pq.peek() != null ? pq.peek().first : 0;
    }

    public static double minimiseMaxDistance(int[] arr, int K) {
        int n = arr.length; // size of array.
        int[] howMany = new int[n - 1];
        return 0;
    }
}
