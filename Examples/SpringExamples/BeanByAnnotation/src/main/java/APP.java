import annotation.ClassAnnotation;
import annotation.ClassOfMethodAnnotation;
import injection.InjectionByAttribute;
import injection.InjectionByConstruction;
import injection.InjectionBySetter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {
    public static void main(String[] args) {
        // Get the spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //Class annotation example
        ClassAnnotation classAnnotation= (ClassAnnotation) context.getBean("classAnnotation");
        classAnnotation.sayHi();

        //Method annotation example
        ClassOfMethodAnnotation classOfMethodAnnotation = context.getBean("GetTheClass", ClassOfMethodAnnotation.class);
        classOfMethodAnnotation.sayHi();

        //Injection by attribute example
        InjectionByAttribute injectionByAttribute = context.getBean("injectionByAttribute", InjectionByAttribute.class);
        injectionByAttribute.sayHi();

        //Injection by construction method example
        InjectionByConstruction injectionByConstruction = context.getBean("injectionByConstruction", InjectionByConstruction.class);
        injectionByConstruction.sayHi();

        //Injection by Setter method example
        InjectionBySetter injectionBySetter = context.getBean("injectionBySetter", InjectionBySetter.class);
        injectionBySetter.sayHi();



    }
}
