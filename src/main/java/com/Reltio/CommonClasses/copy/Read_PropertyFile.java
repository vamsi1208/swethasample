//Reading the property file data

package com.Reltio.CommonClasses.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_PropertyFile
{
	Properties prop;
	
public Read_PropertyFile()
{
	File file = new File("./src/test/resources/ConfigFiles/Reltio.Properties");
	  
	FileInputStream fileInput = null;
	try 
	{
		fileInput = new FileInputStream(file);
	} 
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	prop = new Properties();
	
	//load properties file
	try
	{
		prop.load(fileInput);
	} 
	catch (IOException e)
	{
		e.printStackTrace();
	}
	
}

public String passurl()
{
	
    return prop.getProperty("URL");
}

public String loginSheet()
{
	
    return prop.getProperty("LoginSheet");
}
public String excelFile()
{
	String Excel=System.getProperty("user.dir")+prop.getProperty("ExcelFile");
	return Excel;
}
public String addressSheet()
{
	    return prop.getProperty("AddressSheet");
}
public String saveSheet()
{
	
    return prop.getProperty("SaveSheet");
}

public String searchCriteriaSheet()
{
	
    return prop.getProperty("SearchCriteriaSheet");
}


public String from_Email()
{
	
    return prop.getProperty("Email_From");
}

public String getTo_Email()
{
	
    return prop.getProperty("Email_To");
}

public String getBCC()
{
	
    return prop.getProperty("Email_bcc");
}

public String getMyPassword()
{
	
    return prop.getProperty("Email_Password");
}

public String gethostno()
{
	
    return prop.getProperty("Email_HostNo");
}

public String getport()
{
	
    return prop.getProperty("Email_PortNo");
}





}
