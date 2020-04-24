package com.kwri.auto.ui.pages;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.inject.Inject;
import com.kwri.auto.ui.di.World;
import com.kwri.auto.ui.methods.Common;

public class AgentSitePage extends BasePage {
	@Inject
	public AgentSitePage(World world) {
		super(world);
	}

	Common common = new Common(world.driver);
	WebDriverWait wait = new WebDriverWait(world.driver, 30);
	/**
	 * Agent Site PageNavigation
	 */
	
	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement btn_Login;

	@FindBy(xpath = "//button[contains(@class,'signup')]")
	private WebElement btn_SignUp;
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	
	@FindBy(xpath = "//div[contains(@class,'KWNavigation__avatar')]")
	private WebElement AvatarIcon;

	@FindBy(xpath = "//span[contains(text(),'Sign out')]")
	private WebElement btn_SignOut;

	@FindBy(xpath = "//span[text()='Continue']")
	private WebElement btn_Continue;
	////button[@class='KWButton KWButton--primary']/child::*

	@FindBy(xpath = "//input[contains(@placeholder,'Address')]")
	private WebElement input_City;
	
	@FindBy(xpath = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::*/child::*/child::*/child::*")
	private WebElement btn_picture1;
	
	public WebElement getbtn_picture1() {
		return btn_picture1;
	}
	
	public WebElement getbtn_Continue() {
		return btn_Continue;
	}
	
	public WebElement getinput_City() {
		return input_City;
	}
	
	
	public WebElement getbtn_Login() {
		return btn_Login;
	}

	public WebElement getbtn_SignUp() {
		return btn_SignUp;
	}

	public WebElement getbtn_Search() {
		return btn_Search;
	}
	
	public WebElement get_AvatarIcon() {
		return AvatarIcon;
	}
	
	public WebElement getbtn_SignOut() {
		return btn_SignOut;
	}

	/**
	 * Login Modal
	 */
	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement txt_EmailAddress;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement txt_Password;
	
	@FindBy(xpath = "//span[@class and text()='Log in']")
	private WebElement btn_ModalLogIn;

	public WebElement gettxt_EmailAddress() {
		return txt_EmailAddress;
	}

	public WebElement gettxt_Password() {
		return txt_Password;
	}
	
	public WebElement getbtn_ModalLogIn() {
		return btn_ModalLogIn;
	}
	
	/**
	 * Method for Login
	 */
	public void Login(String email, String password) {
		
		txt_EmailAddress.sendKeys(email);
		txt_Password.sendKeys(password);
		getbtn_Login().click();
	}
	
	/**
	 * Registration Modal
	 */
	@FindBy(xpath = "//input[@placeholder='First name']")
	private WebElement txt_FirstName;
	
	@FindBy(xpath = "//input[@placeholder='Last name']")
	private WebElement txt_LastName;

	@FindBy(xpath = "//div[contains(text(),'You’re all set!')]")
	private WebElement div_AllSet;
	
	@FindBy(xpath = "//button[contains(@class,'Signup')]")
	private WebElement btn_ModalSignUp;
	
	public WebElement gettxt_FirstName() {
		return txt_FirstName;
	}

	public WebElement gettxt_LastName() {
		return txt_LastName;
	}
	
	public WebElement getdiv_AllSet() {
		return div_AllSet;
	}
	
	public WebElement getbtn_ModalSignUp() {
		return btn_ModalSignUp;
	}

	
	
	//METHODS 
	public String CreateRandomEmail()
    {
        
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        return timeStamp+"@kw.com";
    }
	
	public String ReturnValue(WebElement element)
    {
        return element.getAttribute("value");
    }

}