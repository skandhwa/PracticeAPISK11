package Utilities;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ConstantsData.ConstantsData;

public class FetchDataFromProperty {
	
	static FileReader f;
	
	public static Properties getDataFromProperty() 
	{
		
		try {
			f = new FileReader(ConstantsData.PROP_FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			prop.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	

}
