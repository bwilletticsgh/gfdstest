import java.util.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.net.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.*;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.testng.AssertJUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import junit.framework.TestCase;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.Random;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

public class LinkTest extends TestCase {

	public void testLinks() 
	{
		try
		{
			WebDriver ff = new RemoteWebDriver(
							new URL("http://214.37.119.39:4444/wd/hub"), 
							DesiredCapabilities.firefox());
			ff.get("http://214.37.119.21:8080/HelloWorld");    

			List<WebElement> allImages = findAllLinks(ff);    

			System.out.println("Total number of elements found " + allImages.size());
		
			for( WebElement element : allImages)
			{
				System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
				assertEquals("OK", isLinkBroken(new URL(element.getAttribute("href"))));
			}

			ff.quit();			
		}
		catch(Exception exp)
		{
			// Automatic failure
			assertEquals(1, 0);
			System.out.println("Exception occurred: " + exp.getMessage());	    		
		}
	}
	
  private List<WebElement> findAllLinks(WebDriver driver)
	{
 
	  List<WebElement> elementList = new ArrayList<WebElement>();
 
	  elementList = driver.findElements(By.tagName("a"));
 
	  elementList.addAll(driver.findElements(By.tagName("img")));
 
	  List finalList = new ArrayList(); ;
 
	  for (WebElement element : elementList)
	  {
		  if(element.getAttribute("href") != null)
		  {
			  finalList.add(element);
		  }		  
	  }	
 
	  return finalList;
	}
 
	private String isLinkBroken(URL url) throws Exception
	{
		String response = "";
 
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 
		try
		{ 
		    connection.connect();
		    response = connection.getResponseMessage();	        
		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}  				
	}
}