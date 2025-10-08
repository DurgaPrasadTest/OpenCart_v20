package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	
	public void onStart(ITestContext testcontext) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 
		
		repname="Test-Report"+timestamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname);
		
		sparkReporter.config().setDocumentTitle("Opencart Automation Report");
		sparkReporter.config().setReportName("Opencart Functional Testing");
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    extent=new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    extent.setSystemInfo("Application", "Opencart");
	    extent.setSystemInfo("Module", "Admin");
	    extent.setSystemInfo("Sub Module", "Customers");
	    extent.setSystemInfo("Application", "Opencart");
	    extent.setSystemInfo("User Name", System.getProperty("user.name"));
	    extent.setSystemInfo("Enviroment", "QA");
	    
	    String os=testcontext.getCurrentXmlTest().getParameter("os");
	    extent.setSystemInfo("Operating System", os);
	    
	    String browser=testcontext.getCurrentXmlTest().getParameter("browser");
	    extent.setSystemInfo("Operating System", browser);
	    
	    List<String> includeGroups= testcontext.getCurrentXmlTest().getIncludedGroups();
	    if(!includeGroups.isEmpty()) {
	    	extent.setSystemInfo("Groups", includeGroups.toString());
	    }
	}
	
	public void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //to display groups in reports
		test.log(Status.PASS, result.getName()+"got successfully Executed");
	}

	
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); 
		test.log(Status.FAIL, result.getName()+"got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try {
			String imgPath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkippked(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); 
		test.log(Status.SKIP, result.getName()+"got skipped");
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext testcontext) {
		extent.flush();
		
		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repname;
		File extentReport=new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*try { 
			URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repname);
			
			//Create the email message
			ImageHtmlEmail email=new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googleemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("premaki155@gmail.com","password"));
			email.setSSLOnConnect(true);
			email.setFrom("premaki155@gmail.com"); //sender
			email.setSubject("Test Result");
			email.setMsg("Please find the attached Report...");
			email.addTo("siramdasudurgaprasad@gmail.com");//Receiver
			email.attach(url, "exten report", "Please check report....");
			email.send();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
	}

}
