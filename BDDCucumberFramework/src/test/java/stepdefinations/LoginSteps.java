package stepdefinations;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;

public class LoginSteps {
	WebDriver driver;
	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Given("User is on Application Login Page")
	public void user_is_on_application_login_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

	}

	@When("Application Login Page Title is Swag Labs")
	public void application_login_page_title_is_swag_labs() {
		String expectedTitle = "Swag Labs";
		String acutalTitle = driver.getTitle();
		Assert.assertEquals(acutalTitle, expectedTitle);
	}

	@Then("user enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {
		// Username: standard_user
		// Password: secret_sauce
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Username: "+ username +"  Password: "+password);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.id("login-button")).click();
		wait(1000);
	}

	@When("user able to see the alert of password breach")
	public void user_able_to_see_alert_of_password_breach() {
		System.out.print("Logged In!");
		driver.close();
	}
}
