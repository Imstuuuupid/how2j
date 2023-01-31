package middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 谢子轩
 * @date 2022/11/02 11/57
 */
public class JdbcTest {
    public static void main(String[] args) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("数据库驱动加载成功");
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/things", "root", "123456");
            System.out.println("数据库连接成功");
            Statement sql = conn.createStatement();
//            String executeSql = "insert into `jdbc_test` (id,comment) value(1,'this is a jdbc example.')";
            String executeSql = "select * from jdbc_test";
            ResultSet resultSet = sql.executeQuery(executeSql);
            System.out.println("sql执行成功");
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String comment = resultSet.getString(2);
                System.out.println("id : " + id + " ,commnet : " + comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
