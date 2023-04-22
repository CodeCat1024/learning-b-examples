package injection;

import org.springframework.stereotype.Component;

@Component
public class BeInjectionClass {
    public void sayHi() {
        System.out.println("Hello World");
    }
}
