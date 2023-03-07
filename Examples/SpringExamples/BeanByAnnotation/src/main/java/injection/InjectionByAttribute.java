package injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectionByAttribute {

    // You can replace @Autowired with @Resource
    // Use @Resource you can set the parameter to change the name that you will get
    // But @Resource can't be used for constructor
    @Autowired
    private BeInjectionClass beInjectionClass;
    public void sayHi(){
        beInjectionClass.sayHi();
    }
}
