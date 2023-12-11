package systemdesign.designpattern.behavioral.ChainOfResponsibility.logger;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(LogProcessor.ERROR,"Exception happens");
        logProcessor.log(LogProcessor.DEBUG,"Need to debug this");
        logProcessor.log(LogProcessor.INFO,"This is info");
    }
}
