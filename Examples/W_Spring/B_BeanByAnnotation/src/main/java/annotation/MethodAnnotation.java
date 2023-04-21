package annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MethodAnnotation {
    @Bean(name = {"GetTheClass"})
    public ClassOfMethodAnnotation classOfMethodAnnotation() {
        ClassOfMethodAnnotation classOfMethodAnnotation = new ClassOfMethodAnnotation();
        return classOfMethodAnnotation;
    }
}
