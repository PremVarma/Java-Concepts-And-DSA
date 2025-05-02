package basics.collections;

import java.util.Hashtable;

public class HashTableExample {
    // Shared Hashtable for page visitor counts
    private static final Hashtable<String, Integer> visitorCounts = new Hashtable<>();

    public static void main(String[] args) throws InterruptedException {
        // Create two threads to simulate web servers
        Thread server1 = new Thread(new ServerTask("Server1"));
        Thread server2 = new Thread(new ServerTask("Server2"));

        // Start threads
        server1.start();
        server2.start();

        // Wait for threads to finish
        server1.join();
        server2.join();

        // Print final state
        System.out.println("\nFinal Visitor Counts: " + visitorCounts);
        System.out.println("Total pages: " + visitorCounts.size());
    }

    static class ServerTask implements Runnable {
        private final String serverName;

        ServerTask(String serverName) {
            this.serverName = serverName;
        }

        @Override
        public void run() {
            // Initialize pages if absent
            visitorCounts.putIfAbsent("home", 0);
            visitorCounts.putIfAbsent("about", 0);
            visitorCounts.putIfAbsent("contact", 0);

            // Simulate 5 visits to each page
            for (int i = 0; i < 5; i++) {
                // Increment home page count
                Integer homeCount = visitorCounts.get("home");
                visitorCounts.put("home", homeCount + 1);
                System.out.println(serverName + ": Incremented home to " + (homeCount + 1));

                // Increment about page count
                Integer aboutCount = visitorCounts.get("about");
                visitorCounts.put("about", aboutCount + 1);
                System.out.println(serverName + ": Incremented about to " + (aboutCount + 1));

                try {
                    Thread.sleep(100); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}