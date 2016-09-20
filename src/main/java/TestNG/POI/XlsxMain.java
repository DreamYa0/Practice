package TestNG.POI;

/**
 * Created by DreamYao on 2016/6/8.解析xlsx格式的Excel表格
 */
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class XlsxMain {

    public static void main( String[] args) throws IOException {
        XlsxMain xlsxMain = new XlsxMain();
        xlsxMain.readXlsx();
    }

    private void readXlsx() throws IOException{
        String fileName = "D:\\NewWork\\T_Student_2.xlsx";
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileName);
        // 循环工作表Sheet
        for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++){
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt( numSheet);
            if(xssfSheet == null){
                continue;
            }
            // 循环行Row
            for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){
                XSSFRow xssfRow = xssfSheet.getRow( rowNum);
                if(xssfRow == null){
                    continue;
                }
                // 循环列Cell
                for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++){
                    XSSFCell xssfCell = xssfRow.getCell( cellNum);
                    if(xssfCell == null){
                        continue;
                    }
                    System.out.print(" "+getValue(xssfCell));
                }
                System.out.println();
            }
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfCell){
        if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){
            return String.valueOf( xssfCell.getBooleanCellValue());
        }else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){
            return String.valueOf( xssfCell.getNumericCellValue());
        }else{
            return String.valueOf( xssfCell.getStringCellValue());
        }
    }
}
