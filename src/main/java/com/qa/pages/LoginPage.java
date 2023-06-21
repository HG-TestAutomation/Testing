package com.qa.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.qa.util.WebActions;

public class LoginPage {
	
    private Page page;
    
   
    private final Locator USERNAME_EDITBOX;
    private final Locator PASSWORD_EDITBOX;
      
    

    public LoginPage(Page page) {
        this.page = page;
        this.USERNAME_EDITBOX = page.getByLabel("Username or email address *");
        this.PASSWORD_EDITBOX = page.locator("#password");
         
    }
    
//    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My account")).first().click();
//    page.getByLabel("Username or email address *").click();
//    page.getByLabel("Username or email address *").fill("admin");
//    page.locator("#password").click();
//    page.locator("#password").fill("password");
//    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();

    public void navigateToUrl(String url) {
        this.page.navigate(WebActions.getProperty(url));
    }
  
    public void enterUsername(String username) {
       
    	USERNAME_EDITBOX.click();
    	USERNAME_EDITBOX.fill(username);
    }

    public void enterPassword(String password) {
        //PASSWORD_EDITBOX.fill(WebActions.decrypt(password));
    	PASSWORD_EDITBOX.click();
    	PASSWORD_EDITBOX.fill(password);
    }

    public void clickOnAccountButton() {
        this.page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My account")).first().click();  // Clicks on the Exact text
    }
    
    
    public void clickOnButton(String button) {
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(button)).first().click();  // Clicks on the Exact text
    }
    
    

}



