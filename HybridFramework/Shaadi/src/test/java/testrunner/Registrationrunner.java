package testrunner;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import steps.RegistrationSteps;
import utils.Base;
public class Registrationrunner extends Base {

	@Test(dataProvider="dp")
	public void runner(String data) throws IOException, ParseException
	{
		String input[]=data.split(",");
		System.out.println("Testing Started");
		Base b=new Base();
		driver=b.getBrowserDriver();
		driver.manage().window().maximize();
		driver.get(input[0]);
		RegistrationSteps rs=new RegistrationSteps(driver);
		rs.panel1();
		rs.verifyCommunity(input[1]);
		System.out.println("Testing Ended");



	}
}
