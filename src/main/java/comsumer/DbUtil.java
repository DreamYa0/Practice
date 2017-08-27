package comsumer;

import com.alibaba.fastjson.JSON;
import com.zhubajie.autotest.service.api.QaResultService;
import com.zhubajie.autotest.service.common.Result;
import com.zhubajie.autotest.service.model.CaseDataIntoInModel;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import static comsumer.AbstractResourceUtils.getBean;

/**
 * Created by DreamYao on 2016/12/17.
 * 数据库连接工具类，用作对数据库进行查询操作，目前只提供查询操作，
 * 后期根据需要再提供更新、插入、删除操作
 */
public class DbUtil {
    private static final String URL = "jdbc:mysql://192.168.142.12:3306/xxxxx_qa?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=round";
    private static final String User = "root";
    private static final String Password = "xxxx";
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static Connection conn;

    private DbUtil(){}

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
     * 返回数据库响应查询语句结果的Json数据封装结果值
     * 这个类负责在数据库中进行数据的查询，和对查询结果进行数据封装
     */
    public static List<QaMethod> queryValue(String sqlString) {
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
        List<QaMethod> obj = null;
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
            obj =qr.query(conn, sqlString, new BeanListHandler<>(QaMethod.class));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return obj;
    }

    public static void insertValue(String sqlString,Object[] params){
        conn=getConnection();
        QueryRunner qr = new QueryRunner();//创建SQL执行类对象
        try {
            qr.insert(conn, sqlString, new BeanHandler<>(QaMethod.class),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
    }

    //测试调用方法
    public static void main(String[] args) {

        /*String sql1 = "insert into qa_method (project_id,class_name,methods_name,methods_parameter,methods_return,is_pass,create_time) values(?,?,?,?,?,?,?)";
        Object[] params1 = {1,"dreamyao","dreamYao","aaa","bbb",1,"2014-09-24"};
        insertValue(sql1,params1);*/
        String sql2 = "select id,project_id,project_name,class_name,methods_name,methods_parameter,methods_return,is_pass,round,run_author,create_time from qa_method";
        List<QaMethod> methods = queryValue(sql2);
        System.out.println(JSON.toJSONString(methods));
        QaResultService qaResultService = getBean("qaResultService");
        QaResultService qaResultService1 = getBean(QaResultService.class);
        Iterator<QaMethod> iterator=methods.iterator();
        QaMethod qaMethod;
        CaseDataIntoInModel model=new CaseDataIntoInModel();
        while (iterator.hasNext()) {
            qaMethod = iterator.next();
            model.setProjectId(qaMethod.getProject_id());
            model.setClassName(qaMethod.getClass_name());
            model.setMethodsName(qaMethod.getMethods_name());
            model.setMethodsParameter(qaMethod.getMethods_parameter());
            model.setMethodReturn(qaMethod.getMethods_return());
            model.setIsPass(qaMethod.getIs_pass());
            model.setRound(qaMethod.getRound());
            model.setRunAuthor(qaMethod.getRun_author());
            model.setCreateTime(qaMethod.getCreate_time());
            Result<Boolean> result = qaResultService.saveTestResult(model);
            System.out.println(JSON.toJSONString(result));
        }
    }
}
