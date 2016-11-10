package Java_AutoTest_Framework.com.dataset.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by DreamYao on 2016/6/8.P34整个工作薄的解析
 */
public class ExcelPaser {
    private org.apache.poi.ss.usermodel.Workbook wb = null;
    private HashMap<String, SheetData> sheetDataMap = new HashMap<String, SheetData>();
    private int sheetNum = -1;

    public ExcelPaser(InputStream in) {
        try {
            wb = WorkbookFactory.create(in);
            sheetNum = wb.getNumberOfSheets();
            setSheetDataMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private void setSheetDataMap() {
        for (int sheetIndex = 0; sheetIndex < sheetNum; sheetIndex++) {
            String sheetName = wb.getSheetName(sheetIndex);
            SheetData sheetdata = new SheetData(wb.getSheetAt(sheetIndex));
            sheetDataMap.put(sheetName, sheetdata);
        }
    }

    public SheetData getSheetDataByName(String sheetName) {
        return sheetDataMap.get(sheetName);
    }

    public int getSheetIndex(String sheetName) {
        int index = wb.getSheetIndex(sheetName);
        return index;
    }

    public String getText(String sheetName, int row, int column) {
        return getSheetDataByName(sheetName).getText(row, column);
    }
}
