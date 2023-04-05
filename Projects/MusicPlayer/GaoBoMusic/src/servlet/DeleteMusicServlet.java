package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-06-23
 * Time: 16:15
 */
@WebServlet("/deleteServlet")
public class DeleteMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("删除指定音乐！");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> map=new HashMap<>();
        String strId = req.getParameter("id");
        int id = Integer.parseInt(strId);
        System.out.println("id:"+ id);
        try {
            MusicDao musicDao = new MusicDao();
            //1.查找有没有当前id
            Music music = musicDao.findMusicById(id);
            //没有这个id的音乐 直接返回
            if(music == null) return;
            //2、如果有就开始删除库中的音乐
            int delete = musicDao.deleteMusicById(id);
            System.out.println("delete:"+delete);

            if(delete == 1){
                //3、数据库删除完成后，检查还是否存在。如果不存在，那么删除掉磁盘上的文件
                //File file = new File("E:\\Javaproject\\GaoBoMusic\\web\\"+music.getUrl()+".mp3");
                File file = new File("/home/gaobo/apache-tomcat-8.5.51/webapps/GaoBoMusic/"+music.getUrl()+".mp3");
                System.out.println("文件是否存在："+file.exists());
                System.out.println("file: "+file);
                if(file.delete()){
                    //证明删除成功
                    map.put("msg",true);
                }else {
                    map.put("msg",false);
                    System.out.println("文件名："+file.getName());
                    System.out.println("删除文件失败！");
                }
            }else {
                map.put("msg",false);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //将map转化为json
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(resp.getWriter(),map);
    }
}
