package systemdesign.designpattern.creation.singleton;

public class Main {
    public static void main(String[] args) {
//      Basic Class
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);

//      Real World Example
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println(config1 == config2);  // true

        System.out.println(config1.getDbConnectionString()); // "mongodb://localhost/mydb"
        System.out.println(config2.getApiKey()); // "your_api_key"
    }
}
