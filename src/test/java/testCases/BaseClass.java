package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.internal.ReporterConfig.Property;

public class BaseClass {
	
public static WebDriver driver;

public Logger logger;
public Properties P;
	
	@BeforeClass (groups= {"smoke","sanity","regression"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws InterruptedException, IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		P=new Properties();
		P.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		
		if(P.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//OS
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS");
				return;
			}
			//browser
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching browser");
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
		}
		
		if(P.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			default: System.out.print("Invalid browser"); return;
			
			}
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(P.getProperty("Url"));
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	@AfterClass(groups= {"smoke","sanity","regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomstring() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomnumber() {
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumberic() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
	
	public String captureScreen(String tname) {
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File sourcefile=takesscreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetfilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
		File targetFile=new File(targetfilePath);
		sourcefile.renameTo(targetFile);
		
		return targetfilePath;
	}

}
