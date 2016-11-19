package JDK_API_16;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DreamYao on 2016/11/19.
 */
public class CalendarTest {

    //获取当前时间的前一天
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//向上转型为父类,就只能调用父类中的方法
        System.out.println(df.format(date));
    }
}
