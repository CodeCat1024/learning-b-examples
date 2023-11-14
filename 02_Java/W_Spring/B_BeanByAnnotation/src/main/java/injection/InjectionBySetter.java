package injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectionBySetter {
    private BeInjectionClass beInjectionClass;

    @Autowired
    public void setBeInjectionClass(BeInjectionClass beInjectionClass) {
        this.beInjectionClass = beInjectionClass;
    }

    public void sayHi() {
        beInjectionClass.sayHi();
    }

}
