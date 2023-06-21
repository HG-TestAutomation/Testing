package stepdefinitions;


import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Login_steps {
	
	 LoginPage loginPage = new LoginPage(DriverFactory.getPage());
	 HomePage homePage = new HomePage(DriverFactory.getPage());

	 @Given("user navigates to {string}")
	 public void user_navigates_to(String url) {
		 
		 loginPage.navigateToUrl(url);
	    
	 }
			  	  
	@Given("enters the login credentials {string} {string}")
	public void enters_the_login_credentials(String username, String password) {
		
		loginPage.clickOnAccountButton();
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	    
	}

	@Given("clicks on the {string} button")
	public void clicks_on_the_button(String button) {
		
		loginPage.clickOnButton(button);
	   
	}

	@Then("the user verifies that the page title is displayed {string}")
	public void the_user_verifies_that_the_page_title_is_displayed(String title) {
		
		homePage.verifyTitle(title);
	   
	}
	
	
}


