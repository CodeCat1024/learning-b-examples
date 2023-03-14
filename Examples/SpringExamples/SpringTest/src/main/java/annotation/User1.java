package annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class User1 {
    @Autowired
    private User user;

    public void setUser() {
        user.setId(1);
        user.setName("Java");
    }


    public User getUser() {
        return user;
    }

}
