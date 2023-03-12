package HelloSpringBoot.main;

import HelloSpringBoot._class.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserTest {

    @RequestMapping("/user")
    public User sayhi(Integer id){
        User user = new User();
        user.setId(id);
        user.setName("张三");
        return user;
    }
}
