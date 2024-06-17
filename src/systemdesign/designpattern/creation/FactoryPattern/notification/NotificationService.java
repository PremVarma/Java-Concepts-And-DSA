package systemdesign.designpattern.creation.FactoryPattern.notification;

public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        Notification notification = factory.createNotification("sms");
        notification.notifyUser();

        notification = factory.createNotification("email");
        notification.notifyUser();
    }
}
