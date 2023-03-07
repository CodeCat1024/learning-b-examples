package annotation;

import org.springframework.stereotype.Controller;

@Controller
// And you can use following types of annotation
// Like @Service @Repository @Component @Configuration
public class ClassAnnotation {
    public void sayHi() {
        System.out.println("Hello World");
    }
}
