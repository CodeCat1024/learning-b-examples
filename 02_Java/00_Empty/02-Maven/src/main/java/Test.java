import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class User {
    public final char value;
    private String password;

    public User() {
        this.value = 'a';
    }

}
public class Test {
    public static void main(String[] args) throws SQLException {
        User user = new User();
        System.out.println(user.value);

    }
}
