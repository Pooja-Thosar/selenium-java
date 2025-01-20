import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Para2 {
	
	public static Object readFileExcel(int row,int cell)
	{
		Object var=null;
		try {
			FileInputStream file = new FileInputStream(new File (getResourcePath("Test")));
			Cell cl = WorkbookFactory.create(file).getSheetAt(0).getRow(row).getCell(cell);
			CellType celltype =  cl.getCellType();
		} catch (FileNotFoundException e) {
			if (celltype == CellType.NUMERIC) {
                var = cl.getNumericCellValue();
            } else if (celltype == CellType.BOOLEAN) {
                var = cl.getBooleanCellValue();
            } else if (celltype == CellType.STRING) {
                var = cl.getStringCellValue();
            } else {
                throw new IllegalArgumentException("Unexpected value you are trying to fetch");
            }
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static String getResourcePath(String fileName)
	{
		String cwd = System.getProperty("user.dir");
		return Paths.get(cwd,"src","test","java",fileName).toString();
	}
	

}
