package pkg1;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomClasses.LoginOrSignUpPage;
import pomClasses.SignUpPage;

public class ForTestNg {
	WebDriver driver;
	
	/*@BeforeClass
	public void openBrowser() {
		
		System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");//key ,path
	
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}*/
	
	@Parameters("browser")
	@BeforeTest
	public void OpenBrowser(String browserName)
	{
		System.out.println("Open Browser before excute the test method..");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();	
		}
		
		/*if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Azhar Patel\\Downloads\\geckodriver-v0.32.1-win32\\geckodriver.exe" );
			driver= new FirefoxDriver();	
		}*/
		
		if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\Azhar Patel\\Downloads\\edgedriver_win64\\msedgedriver.exe" );
			driver= new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void openSignUp()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		LoginOrSignUpPage loginOrSignUpPage=new LoginOrSignUpPage(driver);
		loginOrSignUpPage.clickCreatenewacc();
	}
	
	@Test	//(priority=1 )
	public void signupPage() {
		System.out.println("Test1");
		SignUpPage signUpPage=new SignUpPage(driver);
		signUpPage.clickOntermsCondition();
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actualUrl);
		String actualTitle=driver.getTitle();
		System.out.println("Actual title is "+actualTitle);
		String expUrl="https://www.facebook.com/legal/terms/update";
		String expTitle="Facebook";
		if(actualUrl.equals(expUrl) && actualTitle.equals(expTitle))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
	}
	
	@Test	//(priority = 2 , dependsOnMethods= {"signupPage"}, invocationCount=2)
	public void privacyPolicy()
	{
		System.out.println("Test2");
		SignUpPage signUpPage=new SignUpPage(driver);
		signUpPage.clickOnPrivacyPolicy();
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actualUrl);
		String actualTitle=driver.getTitle();
		System.out.println("Actual title is "+actualTitle);
		String expUrl  ="https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0";
		String expTitle="Meta Privacy Policy – How Meta collects and uses user data | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
		if(actualUrl.equals(expUrl) && actualTitle.equals(expTitle))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
	}
	
	@Test	//(priority=3)
	public void cookiesPolcy()
	{
		System.out.println("Test3");
		SignUpPage signUpPage=new SignUpPage(driver);
		signUpPage.clickcookiesPolicy();
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String actualUrl=driver.getCurrentUrl();
		System.out.println("Actual url is "+actualUrl);
		String actualTitle=driver.getTitle();
		System.out.println("Actual title is "+actualTitle);
		String expUrl="https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0";
		String expTitle="Meta Cookies Policy | Privacy Centre | Manage your privacy on Facebook, Instagram and Messenger | Facebook Privacy";
		if(actualUrl.equals(expUrl) && actualTitle.equals(expTitle))
		{
			System.out.println("Passed");
		}else
		{
			System.out.println("Failed");
		}
	}
	@AfterMethod
	public void closeCurrentTab()
	{
		System.out.println("After Method");
		driver.close();
		
		ArrayList<String> addr=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
	}
	
	@AfterClass
	public void closeAllTab()
	{
		System.out.println("After Class");
		driver.quit();
	}
}