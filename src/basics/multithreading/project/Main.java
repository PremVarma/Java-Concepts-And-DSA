package basics.multithreading.project;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

abstract class DataCollector<T> implements Callable<List<T>> {
    protected final int batchSize;
    protected final Function<Integer, List<T>> dataProvider;
    protected final int start;

    public DataCollector(int batchSize, Function<Integer, List<T>> dataProvider, int start) {
        this.batchSize = batchSize;
        this.dataProvider = dataProvider;
        this.start = start;
    }
}

abstract class DataTransformer<T, R> implements Callable<List<R>> {
    protected final List<T> data;
    protected final Function<T, R> transformer;

    public DataTransformer(List<T> data, Function<T, R> transformer) {
        this.data = data;
        this.transformer = transformer;
    }
}

abstract class DataProcessor<T, R> implements Callable<R> {
    protected final List<T> transformedData;
    protected final Function<List<T>, R> dataProcessor;

    public DataProcessor(List<T> transformedData, Function<List<T>, R> dataProcessor) {
        this.transformedData = transformedData;
        this.dataProcessor = dataProcessor;
    }
}

class MyDataCollector<T> extends DataCollector<T> {
    public MyDataCollector(int batchSize, Function<Integer, List<T>> dataProvider, int start) {
        super(batchSize, dataProvider, start);
    }

    @Override
    public List<T> call() throws Exception {
        return dataProvider.apply(start);
    }
}

class MyDataTransformer<T, R> extends DataTransformer<T, R> {
    public MyDataTransformer(List<T> data, Function<T, R> transformer) {
        super(data, transformer);
    }

    @Override
    public List<R> call() throws Exception {
        List<R> transformedData = data.stream()
                .map(transformer)
                .toList();

        return transformedData;
    }
}

class MyDataProcessor<T, R> extends DataProcessor<T, R> {
    public MyDataProcessor(List<T> transformedData, Function<List<T>, R> dataProcessor) {
        super(transformedData, dataProcessor);
    }

    @Override
    public R call() throws Exception {
        dataProcessor.apply(transformedData);
        return null;
    }
}


abstract class PeriodicLogger implements Runnable {
    private final long intervalInMinutes;

    public PeriodicLogger(long intervalInMinutes) {
        this.intervalInMinutes = intervalInMinutes;
    }

    @Override
    public void run() {
        while (true) {
            try {
                log(); // Implement the log method in your concrete logging class
                TimeUnit.MINUTES.sleep(intervalInMinutes);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break; // Exit the loop on interruption
            }
        }
    }

    protected abstract void log();
}


class MyLogger extends PeriodicLogger {
    public MyLogger(long intervalInMinutes) {
        super(intervalInMinutes);
    }

    @Override
    protected void log() {
        // Implement your logging logic here
        System.out.println("Logging something at regular intervals");
    }
}



public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Define your data provider function
        Function<Integer, List<String>> dataProvider = start -> {
            // Simulate fetching data from a database
            List<String> data = new LinkedList<>();
            for (int i = start; i < start + 10; i++) {
                data.add("Number " + i);
            }
            return data;
        };

        // Define your transformation function (e.g., from Integer to String)
        Function<String, String> transformer = data -> {
            System.out.println("Transforming data: " + data + Thread.currentThread().getName());
            return data + " transformed";
        };

        // Define your data processor function
        Function<List<String>, Void> dataProcessor = data -> {
            // Simulate processing the transformed data in a different table
            System.out.println("Processed data: " + data + Thread.currentThread().getName());
            return null;
        };

        int start = 0;
        while (start < 100) {
            MyDataCollector<String> collector = new MyDataCollector<String>(10, dataProvider, start);
            Future<List<String>> collectorFuture = executorService.submit(collector);

            try {
                List<String> collectedData = collectorFuture.get();

                MyDataTransformer<String, String> transformerCallable = new MyDataTransformer<String, String>(collectedData, transformer);
                Future<List<String>> transformerFuture = executorService.submit(transformerCallable);

                // Use a Future to retrieve the result of the transformer asynchronously
                try {
                    List<String> transformedData = transformerFuture.get();

                    MyDataProcessor<String,Void> processorCallable = new MyDataProcessor<String,Void>(transformedData, dataProcessor);
                    executorService.submit(processorCallable);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            start += 10;
        }
        MyLogger logger = new MyLogger(1); // Log every 1 minute
        executorService.submit(logger);

        executorService.shutdown();

    }
}

