package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends Base{

	public void waitExplicit(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,2000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

		
}
