package systemdesign.designpattern.behavioral.ChainOfResponsibility.logger;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
            return;
        }
        super.log(logLevel, message);
    }
}
