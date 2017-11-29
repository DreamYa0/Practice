package autotestframework.dataset.excel;

import autotestframework.dataset.MockAPI.MockAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * Created by DreamYao on 2016/6/8.
 */
public class CaseLoader {
    static {
        loadExcel();
    }

    private static SheetData sheetData;

    public static void loadExcel() {
        String path = "D:\\NewWork\\T_Student_2.xlsx";//文件路径
        String sheetName = "TestComplex";//实际项目中这两个可来自配置文件
        ExcelPaser reader = null;
        long now = System.currentTimeMillis();
        try {
            InputStream in = new FileInputStream(path);
            reader = new ExcelPaser(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (reader != null) {
            sheetData = reader.getSheetDataByName(sheetName);
            long delta = System.currentTimeMillis() - now;
            System.out.println("\n Time used in ms::" + delta);
        }
    }

    public static String[] getCallList() {
        return sheetData.getColumnData(0);
    }

    public static String[] getParams(int rowIndex) {
        return sheetData.getRowData(rowIndex);
    }

    public static void main(String[] args) {
        Class<?> clazz = MockAPI.class;
        Method[] methods = clazz.getDeclaredMethods();
        String[] callList = getCallList();
        for (int i = 1; i < callList.length; i++) {
            for (Method m : methods) {
                if (m.getName().equalsIgnoreCase(callList[i])) {
                    try {
                        m.invoke(new MockAPI(), (Object) getParams(i));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
