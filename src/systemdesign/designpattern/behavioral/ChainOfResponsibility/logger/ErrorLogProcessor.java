package systemdesign.designpattern.behavioral.ChainOfResponsibility.logger;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == ERROR) {
            System.out.println("ERROR: " + message);
            return;
        }
        super.log(logLevel, message);
    }
}
