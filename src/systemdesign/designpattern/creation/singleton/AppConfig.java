package systemdesign.designpattern.creation.singleton;

public class AppConfig {
    private String dbConnectionString = "mongodb://localhost/mydb";
    private String apiKey = "API_KEY";
    private static AppConfig instance;

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getDbConnectionString() {
        return dbConnectionString;
    }

    public String getApiKey(){
        return apiKey;
    }
}
