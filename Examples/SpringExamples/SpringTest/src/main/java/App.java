import annotation.USERComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        USERComponent user = (USERComponent) context.getBean("USERComponent");
        System.out.println(user.sayHi("Kate"));
    }
}
