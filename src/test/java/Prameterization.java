
 import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.annotations.Test;

public class Prameterization {
	
	public static Object readExceFile(int row,int cell)
	{
		Object var = null ;
		try {
			FileInputStream file = new FileInputStream(new File(getResourcePath("Test.xlsx")));
			Cell cl = WorkbookFactory.create(file).getSheetAt(0).getRow(row).getCell(cell);
			CellType celltype =  cl.getCellType();
			switch (celltype) {
			case NUMERIC:
				var= cl.getNumericCellValue();
				break;
			case BOOLEAN:             
				var= cl.getBooleanCellValue();
				break;
			case STRING:
				var = cl.getStringCellValue();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value your are trying to fetch ");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return var;
	}




	public static void main(String[] args) 
	{
		Object a =  readExceFile(0, 0);
		Object b = readExceFile(0, 1);
		Object c = readExceFile(0, 2);

		System.out.println(a+" "+b+" "+c);
	//	System.out.println(getResourcePath("Test"));

	}

	public static String getResourcePath(String filename) {
		String cwd = System.getProperty("user.dir");
		return Paths.get(cwd, "src","main","resources",filename).toString();
	}
}
