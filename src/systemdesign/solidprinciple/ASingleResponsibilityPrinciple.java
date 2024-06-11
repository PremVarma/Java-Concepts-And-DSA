package systemdesign.solidprinciple;

public class ASingleResponsibilityPrinciple {
    public static void main(String[] args) {

    }
}

//This class is handling two responsibility as per SRP it should have one reason to change
class Report {
    private final String content;

    public Report(String content) {
        this.content = content;
    }

    public void generateReport() {
        System.out.println("Generating Report: " + content);
    }

    public void saveReport() {
        System.out.println("Saving Report: " + content);
    }
}

// Converting them into classes with SRP

class ReportGenerator {
    private String content;

    public ReportGenerator(String content) {
        this.content = content;
    }

    public void generateReport() {
        System.out.println("Generating Report: " + content);
    }
}

class ReportSaver {
    private String content;

    public ReportSaver(String content) {
        this.content = content;
    }

    public void saveReport() {
        System.out.println("Saving Report: " + content);
    }
}
