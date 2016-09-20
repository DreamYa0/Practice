package com.dataset.db;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by DreamYao on 2016/6/9.
 * P44
 * 使用Apache DbUtils从数据库中获取数据
 * 在Iterator类中，我们经常用到两个方法： hasNext(), next(),
 * 具体含义： next(),是返回当前元素，并指向下一个元素。
 * hasNext()，则是判断当前元素是否存在，并指向下一个元素（即所谓的索引）
 * 如： 枚举工号
 * Map  map = new HashMap();
 * map = new HashMap();
 * map.put("1155669", "Tom");
 * map.put("1155689", "Jane");
 * map.put("1165669", "Kevin");
 * map.put("1155660", "Gavin");
 * Set keySet = map.keySet();
 * Iterator  iterator = keySet.iterator();
 * while (iterator.hasNext()) {
 * String  key = (String) iterator.next();
 * System.out.println(key);
 * }
 */
public class Dbutil {
    private static final String URL = "jdbc:mysql://121.49.110.41:3306/teacherpic?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=round";
    private static final String User = "teacherpic";
    private static final String Password = "teacherpic_77853!";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static Connection conn;

    //数据库连接方法
    private static Connection getConnection() {
        Connection conn = null;
        DbUtils.loadDriver(Driver);//加载数据库驱动如果成功返回true否则返回false
        try {
            conn = DriverManager.getConnection(URL, User, Password);//连接数据库
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     *返回数据库响应查询语句结果的Json数据封装结果值
     *这个类负责在数据库中进行数据的查询，和对查询结果进行数据封装
     */
    public static final String JsonValue(String sqlString){
        conn = getConnection();
        /**
         * QueryRunner：简化了数据库的增删改查操作，用来替代JDBC中的executeQuery、executeUpdate等方法，
         * 通过与ResultSetHandler配合使用，能够大大减少所写的代码
         * 1.update：执行INSERT、UPDATE或者DELETE等SQL语句
         * 2.insert：执行INSERT语句
         * 3.query：执行SELECT语句
         * 另外，可以调用相关的batch方法来批量操作INSERT、UPDATE或者DELETE等SQL语句
         */
        QueryRunner qr = new QueryRunner();//创建SQL执行类对象
        List list;
        String data = null;
        try {
            /**
             * 执行SQL查询语句
             * org.apache.commons.dbutils.handlers
             * 该包中的类都是对于前述ResultSetHandler的实现
             * 1.ArrayHandler：将ResultSet中的第一行的数据转化成对象数组
             * 2.ArrayListHandler：将ResultSet中所以的数据转化成List，List中存放的是Object[]
             * 3.BeanHandler：将ResultSet中第一行的数据转化成类对象
             * 4.BeanListHandler：将ResultSet中所有数据转化成List，List中存放的是类对象
             * 5.ColumnListHandler：将ResultSet中某一列的数据存成List，List中存放的是Object对象
             * 6.KeyedHandler：将ResultSet中的每一行数据都封装到一个Map里，再把这些map再存到一个map里，其key为指定的key
             * 7.MapHandler：将ResultSet中第一行的数据存成Map映射
             * 8.MapListHandler：将ResultSet中所有的数据存成List，List中存放的是Map
             * 8.ScalarHandler：将ResultSet中一条记录的某一列数据存成Object
             */
            list = qr.query(conn, sqlString, new MapListHandler());
            /**
             * 循环打印出List表中的所以数据，也可循环封装为Json数据打印出
             */
//            for (int i=0;i<list.size();i++){
//                System.out.println(list.get(i));
//            }
            /**
             * 取List表的第一行数据并进行Json封装
             * 从List表里取1-10条数据中的随机一条，然后转化为Json数据格式
             */
//            Random random=new Random();
            data = JSONUtils.toJSONString(list.get(0));
            /**
             * 取List表中的某行值存到Map中，再Map中取出对应字段的value
             */
//            Map map1 = (Map) list.get(0);//去List表的第一行数据存入map1
//            String value=map1.get("name").toString();//去map1中对应字段name的值
//            System.out.println(value);
            /**
             * 取List表中的所有值
             */
//            Iterator ite = list.iterator();//创建迭代器
//            while (ite.hasNext()){
//                Map map= (Map) ite.next();
//                System.out.println(map.toString());
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return data;
    }

    //测试调用方法
    public static void main(String[] args) {
        String a=JsonValue("SELECT id FROM p_teacher LIMIT 0,1");
        System.out.println(a);
    }
}
