package com.qa.pages;

import org.junit.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

	  private Page page;
	    
	    private final Locator NO_BUTTON;
	    private final Locator USERNAME_LINK;
	    
	    public HomePage(Page page) {
	        this.page = page;
	        this.NO_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("No"));
	        this.USERNAME_LINK = page.getByText("Gabriel Mendez");
	        
	    }
	    
	    public void clickNoBtn() {
	    	NO_BUTTON.click();
	    }
	    
	    public void clickUsernameLink() {
	    	USERNAME_LINK.click();
	    }
	    
	    public void verifyTitle(String title) {
	    	
	    	String expected = title;
	    	String actual = page.textContent("xpath=" + "//*[@rel='home']");
			System.out.println("what is displayed is: " + actual);
			Assert.assertEquals(expected, actual);
	    	
	    }

}
