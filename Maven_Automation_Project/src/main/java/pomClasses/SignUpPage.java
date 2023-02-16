package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	@FindBy (xpath="(//input[@type='text'])[2]") 
	private WebElement firstName;
	
	@FindBy (xpath="(//input[@type='text'])[3]") 
	private WebElement surName;
	
	@FindBy (xpath="//input[@aria-label='Mobile number or email address']") 
	private WebElement mobNumOrEmailAddress;
	
	@FindBy (xpath="(//input[@type='password'])[2]") 
	private WebElement newPassword;
	
	@FindBy (xpath="//select[@aria-label='Day']") 
	private WebElement date;
	@FindBy (xpath="//select[@aria-label='Month']") 
	private WebElement month;
	@FindBy (xpath="//select[@aria-label='Year']") 
	private WebElement year;
	
	@FindBy (xpath="(//input[@type='radio'])[2]") 
	private WebElement maleButton;
	
	@FindBy (xpath="(//input[@type='radio'])[1]") 
	private WebElement femaleButton;
	
	@FindBy (xpath="(//input[@type='radio'])[3]") 
	private WebElement customButton;
	
	@FindBy (xpath="//div[@class='_1lch']") 
	private WebElement signUpButton;
	
	@FindBy (xpath="(//a[text()='Terms'])[2]")
	private WebElement termsCondition;
	
	@FindBy (xpath="(//a[text()='Privacy Policy'])[2]")
	private WebElement privacyPolicy;
	
	@FindBy (xpath="//a[text()='Cookies Policy']")
	private WebElement cookiesPolicy;
	
	public  SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendfirstName()
	{ 
		firstName.sendKeys("Azhar");
		
	}
	public void sendSurName()
	{ 
		surName.sendKeys("Patel");
		
	}
	public void sendMobNumOrEmailAddress()
	{ 
		mobNumOrEmailAddress.sendKeys("9767134345");
		
	}
	public void sendNewPassword()
	{ 
		newPassword.sendKeys("Azhar6945@");
		
	}
	public void selectdate()
	{ 
		Select s=new Select(date);
		s.selectByValue("20");
		
	}
	public void selectmonth()
	{ 
		Select s=new Select(month);
		s.selectByValue("12");
		
	}
	public void selectYear()
	{ 
		Select s=new Select(year);
		s.selectByVisibleText("1995");
		
	}
	public void selectMaleButton()
	{ 
		maleButton.click();
		
	}
	public void selectFemaleButton()
	{ 
		femaleButton.click();
		
	}
	public void selectCustomButton()
	{ 
		customButton.click();
		
	}
	
	public void clickOntermsCondition()
	{
		termsCondition.click();
	}
	
	public void clickOnPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public void clickcookiesPolicy()
	{
		cookiesPolicy.click();
	}
	public void clickOnSignUpButton()
	{ 
		signUpButton.click();
		
	}
	
	
}