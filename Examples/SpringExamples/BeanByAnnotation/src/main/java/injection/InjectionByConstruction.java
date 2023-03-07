package injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectionByConstruction {
    private BeInjectionClass beInjectionClass;

    //You only can add the @Autowired to the Construction method one time when there are more than one.
    @Autowired
    public InjectionByConstruction(BeInjectionClass beInjectionClass) {
        this.beInjectionClass = beInjectionClass;

    }

    public InjectionByConstruction() {
        ;
    }

    public void sayHi() {
        beInjectionClass.sayHi();
    }
}
