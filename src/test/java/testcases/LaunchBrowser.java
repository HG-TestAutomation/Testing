package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		double width = screenSize.getWidth();
//		double height = screenSize.getHeight();
		
//		System.out.println(width+"---"+height);
		
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	//BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1536, 864));

	BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
	Page page = context.newPage();
	
	//Page page = browsercontext.newPage();
	 page.navigate("https://tams.preprod.gsa.gov/");
     page.navigate("https://tams.preprod.gsa.gov/login");
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Agree and continue")).click();
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("german.mendez@gsa.gov");
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("GovernmentAuditor@2121");
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login").setExact(true)).click();
     page.getByPlaceholder("Answer").fill("broccoli");
     page.getByText("Do not challenge me on this device for the next 12 hours").click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Verify")).click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("No")).click();
     page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("NOCs")).click();
     page.getByLabel("Issued Date From:").click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Choose Tuesday, May 3rd, 2022")).click();
     page.getByLabel("Issued Date To:").click();
     page.getByText("78910111213").click();
     page.getByLabel("Document Reference Number:").click();
     page.getByLabel("Document Reference Number:").fill("test");
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Apply Search")).click();
     page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("BATCH_TEST_102")).click();
     page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("DRN Details")).click();
     page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("DRN Workflow Log")).click();
     page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Owned By sort ascending")).click();
     page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Close")).click();
     page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reports")).click();
     page.getByRole(AriaRole.COMBOBOX).nth(1).selectOption("Biweekly");
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
     page.locator("#headerContent").getByRole(AriaRole.COMBOBOX).click();
     page.getByText("Gabriel Mendez").click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Logout")).click();
     page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Agree and continue")).click();
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("test is complete....");
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
     System.out.println("test is complete");
     
     page.close();
 	 playwright.close();
    }
	
	
	
	
	//page.close();
	//playwright.close();
	

}
