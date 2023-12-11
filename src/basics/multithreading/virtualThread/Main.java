package basics.multithreading.virtualThread;

// OS Thread executes -> Platform Thread executes -> Virtual Thread

public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Index " + i);
            }
        };
//        These are lightweight thread and available after Java 19
//        Thread vThread1 = Thread.ofVirtual().start(runnable);  // Created Virtual thread and start
//        Thread vThreadUnstarted1 = Thread.ofVirtual().unstarted(runnable); // Create but donot start
//        vThreadUnstarted1.start();
//        try{
//            vThreadUnstarted1.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}
