package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.TestUtil;

public class Registration extends TestUtil {
	public WebDriver driver;

	public Registration(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@data-testid='lets_begin']")
	public WebElement LetsBegin_button;

	@FindBy(css="[name=email]")
	public WebElement email;

	@FindBy(css="[name=password1]")
	public WebElement password;

	@FindBy(xpath="//div[@class='Dropdown-control postedby_selector']")
	public WebElement profileCreator;


	@FindBy(xpath="//div[@class='Dropdown-option'][text()='Son']")
	public WebElement profile;

	@FindBy(xpath="//button[@data-testid='next_button']")
	public WebElement next_button;

	@FindBy(xpath="//div[label[text()='Community']]//div[@class='Dropdown-placeholder is-selected']")
	public WebElement community_list;

}
