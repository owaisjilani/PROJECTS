package steps;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import pageobjects.Registration;

public class RegistrationSteps extends Registration {
	Faker faker = new Faker();
	public String emailAdd=null;
	public String passkey=null;
	public String defaultCommunity=null;

	public RegistrationSteps(WebDriver driver) {
		super(driver);
	}

	public void panel1() {
		LetsBegin_button.click();
		emailAdd=faker.internet().emailAddress();
		passkey=faker.internet().password(4, 10);
		email.sendKeys(emailAdd);
		password.sendKeys(passkey);
		profileCreator.click();
		profile.click();
		next_button.click();

	}

	public void verifyCommunity(String ExpectedCommunity) throws IOException, ParseException 
	{
		waitExplicit(community_list);
		defaultCommunity=community_list.getText();
		System.out.println("The selected community is "+ defaultCommunity);
		jsonDataRetrieve();
		assertEquals(defaultCommunity,ExpectedCommunity,"Community Verification Failed" );
	}


}
