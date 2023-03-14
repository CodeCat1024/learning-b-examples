import annotation.User1;
import annotation.User2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        User1 user1 = context.getBean("user1", User1.class);
        User2 user2 = context.getBean("user2", User2.class);

        //User1使用前
        System.out.println("User1使用前");
        System.out.println("user1的User对象为" + user1.getUser());
        System.out.println("user2的User对象为" + user2.getUser());

        user1.setUser();

        //Users1使用后
        System.out.println("User1使用后");
        System.out.println("user1的User对象为" + user1.getUser());
        System.out.println("user2的User对象为" + user2.getUser());
    }
}
