package HelloSpringBoot.main;

import HelloSpringBoot._class.ReadList;
import HelloSpringBoot._class.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Yml {

    // 读取对象
    @Autowired
    private Student student;

    @ResponseBody
    @RequestMapping("object")
    public String object() {
        return "对象为：" + student;
    }

    // 读取集合
    @Resource
    private ReadList readList;

    @ResponseBody
    @RequestMapping("list")
    private String list() { return "集合为：" + readList.getName(); }


}
