package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		
		String path=".\\testdata\\LoginData.xlsx"; //Taking xl from testdata floder
		
		ExcelUtility xlutil=new ExcelUtility(path); //Create an object for Utility
		
		int totalrows=xlutil.getRowCount("sheet1");
		int totalcols=xlutil.getCellCount("sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols]; //Create two dimension array which can store cell data
		
		for(int i=1; i<=totalrows; i++) // 1 //read the data from xl storing in two dimensional array
		{
			for(int j=0; j<totalcols; j++) 
			{
				logindata[i-1][j]=xlutil.getCellData("sheet1", i, j); //1, 0
			}
			
		}
		return logindata; //returning two dimension array
	}
}
