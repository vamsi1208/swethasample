// Taking the Screen shot of the page when there is a failure

package com.Reltio.CommonClasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot 
{

	public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
    	try
    	{
    	
    		
        TakesScreenshot ts = (TakesScreenshot)driver;
       
        File source = ts.getScreenshotAs(OutputType.FILE);
          
        String dest ="./ScreenShots/"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    	}
    	catch(Exception e)
    	{
    	
    	return e.getMessage();
    	}
    }
}
