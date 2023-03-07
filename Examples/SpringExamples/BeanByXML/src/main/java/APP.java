import example.TestBean1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.beans.XMLDecoder;

public class APP {
    public static void main(String[] args) {
        // Get the spring context by the ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Get the spring context by the BeanFactory
        //BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

        // Get the Bean only by the id
        //TestBean1 testBean1 = (TestBean1) context.getBean("testBean1");

        // Get the Bean only by the class
        //TestBean1 testBean1 = context.getBean(TestBean1.class);

        // Get the Bean by the id and class
        TestBean1 testBean1 = context.getBean("testBean1", TestBean1.class);

        // Use the Bean
        testBean1.sayHi();
    }
}
