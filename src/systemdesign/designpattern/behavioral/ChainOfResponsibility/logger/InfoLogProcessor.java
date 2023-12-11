package systemdesign.designpattern.behavioral.ChainOfResponsibility.logger;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println("INFO: " + message);
            return;
        }
        super.log(logLevel, message);
    }
}
