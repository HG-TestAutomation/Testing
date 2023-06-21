package testcases;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

public class CapturingVideos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));

		Page page = context.newPage();

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
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Exports")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SmartPay")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SCACs")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Agency Reporting")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("ALC Address")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("User Management")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Reports")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Broadcast Messages")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
	      
		page.close();

		context.close();

		playwright.close();

		}



	



	}


