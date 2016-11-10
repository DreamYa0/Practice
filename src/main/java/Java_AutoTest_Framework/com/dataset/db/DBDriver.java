package Java_AutoTest_Framework.com.dataset.db;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by DreamYao on 2016/6/9.
 * P41
 * 使用JDBC连接数据库
 * Java.sql.SQLException:Value '0000-00-00' can not be represented as java.sql.Date
 * 解决办法:
 * 给jdbc   url加上   zeroDateTimeBehavior参数：
 * datasource.url=jdbc:mysql://localhost:3306/pe?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull
 * zeroDateTimeBehavior=round是为了指定MySql中的DateTime字段默认值查询时的处理方式；默认是抛出异常，
 * 对于值为0000-00-00   00:00:00（默认值）的纪录，如下两种配置，会返回不同的结果：
 * zeroDateTimeBehavior=round   0001-01-01   00:00:00.0
 * zeroDateTimeBehavior=convertToNull   null
 */
public class DBDriver {
    private static final String URL = "jdbc:mysql://121.49.110.41:3308/AccurateSubsidize?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=round";
    private static final String User = "yaojun";
    private static final String Password = "T2v31s0LrY6z";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static Connection conn;

    public static Connection getConnection() {
        Connection connection;
        if (conn != null) {
            connection = conn;
        } else {
            connection = getConnection(Driver, URL, User, Password);
            conn = connection;
        }
        return connection;
    }

    private static Connection getConnection(String driver, String url, String user, String password) {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("New db conn created::" + conn.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection con, Statement stm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
            System.out.println("Connection closed. Bye!");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close database!", e);
        }
    }

    public static ArrayList select(String selectSql) {
        Statement stm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd;
        ArrayList result = new ArrayList();
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(selectSql);
            rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            ArrayList row;
            while (rs.next()) {
                row = new ArrayList();
                for (int i = 1; i < cols; i++) {
                    if (null == rs.getString(i)) {
                        row.add("");
                    } else {
                        row.add(rs.getString(i));
                    }
                }
                result.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(null, stm, rs);
        }
        return result;
    }

    public static void main(String[] args) {
        DBDriver.getConnection();
        String sqlString = "SELECT * FROM T_Student";//取得studentId列
        ArrayList list = select(sqlString);
        System.out.println("*****************String to query::" + sqlString + "*****************");
        /**
         * 打印list数组第一种方式，通过使用toString()方法参数数组可打印版本
         */
//        System.out.println(list.toString());
        /**
         * 打印list数组第二种方式,通过for循环
         */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        /**
         * 打印list数组第三种方式，通过foreach循环遍历
         */
//        for (Object a:list) {
//            System.out.println(a);
//        }
        sqlString = "SELECT id,code FROM T_College";//取得id列
        list = select(sqlString);
        System.out.println("***************String to query::" + sqlString + "****************");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
        System.out.println(list.get(0));//获取list第1行的值
        closeConnection(conn, null, null);
    }
}
