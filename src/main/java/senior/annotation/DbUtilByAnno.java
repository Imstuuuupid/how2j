package senior.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 谢子轩
 * @date 2022/11/07 08/23
 */
@JdbcCon(user = "root", password = "123456", database = "things")
public class DbUtilByAnno {

    public static Connection getCon() {
        Connection res = null;
        try {
            Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
            res = getFromAnnotation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static Connection getFromAnnotation() throws SQLException {
        JdbcCon annotation = DbUtilByAnno.class.getAnnotation(JdbcCon.class);
        System.out.println(annotation);
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", annotation.ip(), annotation.port(), annotation.database(), annotation.encoding());
        Connection connection = DriverManager.getConnection(url, annotation.user(), annotation.password());
        System.out.println("连接成功，url: " + url);
        return connection;
    }

    public static void main(String[] args) {
        Connection con = getCon();
        System.out.println(con);
    }

}
