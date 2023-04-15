package TestPackage1;

import java.io.File;
import java.time.Duration;


import org.jsoup.Connection.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.conistants;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;


	@BeforeTest
	public void beforetestmethod1()
	{


		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"AutomationTestReport.html");

		//initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		//To add system or environment info by using the setSystemInfo method.
		//extent.setSystemInfo("OS", OS);
		extent.setSystemInfo("TestReports", "AutomationReports");

		//configuration items to change the look and feel
		//add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}



	@BeforeMethod
	@Parameters("browsername")
	public void beforeMethodmethod1(String browsername) 
	{

		//logger=extent.createTest(testMethod.name());
		logger=extent.createTest(Method.GET.name());

		setupDriver(browsername);
		driver.manage().window().maximize();
		driver.get(conistants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	@AfterMethod
	public void aftermethodtmethod1(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String methodname=result.getMethod().getMethodName();
			String logText="TestCase"+methodname+"Passwed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS,m);
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			String methodname=result.getMethod().getMethodName();
			String logText="TestCase"+methodname+"Failed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL,m);
		}
		
		
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}



	@AfterTest
	public void aftertesttmethod1()
	{
		extent.flush();
	}

	public void setupDriver(String browsername) 
	{

		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"chromedriver.exe");
			 //System.setProperty("webdriver.chrome.driver","F:\\Testing\\chromedriver\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);

		}else if(browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"msedgedriver.exe");
			//System.setProperty("webdriver.edge.driver","F:\\Testing\\edgedriver_win64 (2)\\msedgedriver.exe");
			EdgeOptions edgop=new EdgeOptions();edgop.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(edgop);
		}else {
			//System.setProperty("webdriver.gecko.driver","F:\\Testing\\geckodriver-v0.31.0-win64 (1)\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+File.separator+"Drivers"+File.separator+"geckodriver.exe");
			driver=new FirefoxDriver();

		}

	}
	
	 


}
