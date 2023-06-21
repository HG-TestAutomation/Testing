package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class TraceViewer {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		
		context.tracing().start(new Tracing.StartOptions()
				  .setScreenshots(true)
				  .setSnapshots(true)
				  .setSources(false));
		Page page = context.newPage();

		 page.navigate("http://localhost:8888/mySite/");
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Beanie” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Beanie with Logo” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Album” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Belt” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Hoodie with Zipper” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Hoodie with Logo” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Select options for “Hoodie”")).click();
	      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Color")).selectOption("blue");
	      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Logo")).selectOption("Yes");
	      page.getByLabel("Hoodie quantity").click();
	      page.getByLabel("Hoodie quantity").dblclick();
	      page.getByText("Sale! 🔍 Hoodie$42.00 – $45.00 This is a variable product. Color Choose an optio").click();
	      page.getByLabel("Hoodie quantity").click();
	      page.getByLabel("Hoodie quantity").fill("7");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Hoodie with Zipper” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Add “Hoodie with Logo” to your cart")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart").setExact(true)).first().click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply coupon")).click();
	      page.getByText("Please enter a coupon code.").click();
	      page.getByPlaceholder("Coupon code").click();
	      page.getByPlaceholder("Coupon code").fill("GMQA100");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply coupon")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout ")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First name *")).fill("Gabriel");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last name *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last name *")).fill("Mendez");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("United States (US)")).click();
	      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("United States (US)").setExact(true)).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address *")).fill("120");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Town / City *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Town / City *")).fill("Rockville");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ZIP Code *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ZIP Code *")).fill("22030");
	      page.getByLabel("Phone *").click();
	      page.getByLabel("Phone *").fill("0000000000");
	      page.getByLabel("Email address *").click();
	      page.getByLabel("Email address *").fill("g@g.com");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place order")).click();
	      page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Ship to a different address?")).locator("label").click();
	      page.getByLabel("Ship to a different address?").uncheck();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("California")).click();
	      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Maryland")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Click here to enter your code")).click();
	      page.getByPlaceholder("Coupon code").click();
	      page.getByPlaceholder("Coupon code").fill("GMQA100");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply coupon")).click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place order")).click();
	      page.getByText("No shipping method has been selected. Please double check your address, or conta").click();
	      page.getByRole(AriaRole.ALERT).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address *")).fill("120 Gibbs");
	      page.locator("form[name=\"checkout\"]").click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Street address *")).fill("120 Gibbs st");
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ZIP Code *")).click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("ZIP Code *")).fill("20850");
	      page.locator("form[name=\"checkout\"]").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place order")).click();
	      page.getByLabel("Ship to a different address?").check();
	      page.locator("#shipping_first_name").click();
	      page.locator("#shipping_first_name").fill("G");
	      page.locator("#shipping_last_name").click();
	      page.locator("#shipping_last_name").fill("M");
	      page.locator("#shipping_company").click();
	      page.locator("#shipping_company").fill("T");
	      page.locator("#shipping_address_1").click();
	      page.locator("#shipping_address_1").fill("123");
	      page.locator("#shipping_city").click();
	      page.locator("#shipping_city").fill("f");
	      page.locator("form[name=\"checkout\"]").click();
	      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("United States (US)").setExact(true)).click();
	      page.locator("#shipping_postcode").click();
	      page.locator("#shipping_postcode").fill("22030");
	      page.locator("form[name=\"checkout\"]").click();
	      page.locator("#shipping_city").fill("fRockville");
	      page.locator("#shipping_city").click();
	      page.locator("#shipping_city").fill("Rockville");
	      page.locator("form[name=\"checkout\"]").click();
	      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("California")).click();
	      page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Maryland")).click();
	      page.locator("form[name=\"checkout\"]").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Place order")).click();
	      page.navigate("http://localhost:8888/mySite/checkout/");
	    
		 page.close();
		
		// Stop tracing and export it into a zip archive.
				context.tracing().stop(new Tracing.StopOptions()
				  .setPath(Paths.get("trace.zip")));

		context.close();

		playwright.close();
		
	}

}
