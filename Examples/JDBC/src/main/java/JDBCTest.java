import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //1，创建好数据源，描述了数据库服务器在哪，向上转型
        DataSource dataSource = new MysqlDataSource();

        //设置数据库所在的地址，向下转型
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mytestdatabase?characterEncoding=utf8&useSSL=false");
        //设置登录数据库的用户名，mysql默认的管理员用户
        ((MysqlDataSource) dataSource).setUser("root");
        //设置登录数据库的密码
        ((MysqlDataSource) dataSource).setPassword("1111");

        //2，让代码和数据库服务器建立连接，此处会出现受查异常，需要进行处理
        Connection connection = (Connection) dataSource.getConnection();

        //让用户输入要插入的数据
        System.out.println("请输入学号");
        int id = scanner.nextInt();
        System.out.println("请输入姓名");
        String name = scanner.next();

        //3，构造SQL语句，操作数据库（可以不加上分号）
        String sql = "insert into student values(?, ?)";
        //进行替换操作
        //包装成一个语句对象
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);
        System.out.println(statement);

        //4，执行SQL，若是insert，update，delete则执行executeUpdate，若是select，则执行executeQuery
        //返回值为影响到了几行，相当于在控制台上得到的数字
        int ret = statement.executeUpdate();
        System.out.println(ret);

        //5，释放资源（先创建的后释放）
        statement.close();
        connection.close();

    }
}
