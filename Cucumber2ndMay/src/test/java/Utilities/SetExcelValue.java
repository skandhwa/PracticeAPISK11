package Utilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;



public class SetExcelValue {
	
	public static Map setExcelValue() throws IOException
	{
		FetchDataFromExcel obj=new FetchDataFromExcel("E:/TestData27thOct.xlsx","Sheet1");
		
		 Map<String, Object> mp = new LinkedHashMap<String, Object>();
		int rowCount = obj.getRowCount();
        int colCount = obj.getColumnCount();
        
       
		
	
        for (int i = 1; i < rowCount; i++) 
        {

           

            
            for (int j = 0; j < colCount; j++) 
            {

                String key = FetchDataFromExcel.getDataExcel(0, j);
                String value = FetchDataFromExcel.getDataExcel(i, j);

                mp.put(key, value);
            }
            
        }
            
          return mp;  

	}
	
		
	
	
}


