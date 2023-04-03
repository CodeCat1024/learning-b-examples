import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSelect {
    public static void main(String[] args) throws SQLException {

        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/mytestdatabase?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1111");

        Connection connection = dataSource.getConnection();

        String sql = "select * from student";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);

        //查询操作返回的临时表
        ResultSet resultSet = statement.executeQuery();

        //遍历结果集合，拿行再拿列
        //next方法表示获取到一行记录，同时把光标往后移动一行
        //如果遍历到表的结果为止，此时的next直接返回false
        while (resultSet.next()) {
            //针对当前这一行来获取数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id + ", name = " + name);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
