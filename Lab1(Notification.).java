//javac NotificationService.java or //javac -d . *.java
//java -cp . package.NotificationService 2
import java.util.*;
public class NotificationService implements NotificationServices{
	private final NotificationDAO storage;
	NotificationService(NotificationDAO storage) {
		this.storage=storage;
	}
	public UUID raiseNotification(String message) {
		return this.storage.addNotification(new Date(),message);
	}
	
	public Date getNotificationTime(UUID id) {
		return this.storage.getNotification(id).getNotificationDate();
	}
	
	@Override
	public String getNotificationMessage(UUID uuid) {
		return this.storage.getNotification(uuid).getNotificationMessage();
	}
	
	public static void main(String[] args) {
		  int count = Integer.parseInt(args[0]);
		  NotificationServices service = new NotificationService(new MapNotificationDAO());
		  Scanner sc = new Scanner(System.in);
		  for (int i = 0; i < count; i++) {
		      System.out.println("Enter the message:");
		      String message = sc.nextLine(); // Allows full sentence
		      UUID id = service.raiseNotification(message);
		      System.out.println("Notification: " + service.getNotificationMessage(id));
		  }
	}	
}
class MapNotificationDAO implements NotificationDAO{
	Map <UUID,NotificationVO> notifications=new HashMap<>();
	
	public UUID addNotification(Date time,String message) {
		UUID id=UUID.randomUUID();
		this.notifications.put(id,new NotificationVO(time,message));
		return id;
	}
	public NotificationVO getNotification(UUID id) {
		return this.notifications.get(id);
	}
}

class NotificationVO {
	Date notificationDate;
	String notificationMessage;
	
	NotificationVO(Date notificationDate,String notificationMessage){
		this.notificationDate=notificationDate;
		this.notificationMessage=notificationMessage;
	}
	
	public Date getNotificationDate() {
		return notificationDate;
	}
	public String getNotificationMessage() {
		return notificationMessage;
	}
}
interface NotificationDAO {
	public UUID addNotification(Date time,String message);
	public  NotificationVO getNotification(UUID id);
}
interface NotificationServices {
	public UUID raiseNotification(String message);
	public Date getNotificationTime(UUID id);
	public String getNotificationMessage(UUID uuid);
}
