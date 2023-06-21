package testcases;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GoForwardOptions;
import com.microsoft.playwright.Playwright;

public class NonIncognitoWindowTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browsercontext = playwright.chromium().launchPersistentContext(Paths.get(""),new BrowserType.LaunchPersistentContextOptions().setHeadless(false));
		
		Page page = browsercontext.newPage();
		page.navigate("http://www.mirrormentalhealth.com");
		System.out.println(page.title());
		
		page.navigate("http://google.com");
		page.goBack();
		Thread.sleep(1000);
		page.goForward();
		Thread.sleep(1000);
	
		page.reload();
		
	
		
		page.close();
		browsercontext.close();
		
		playwright.close();
		
	}

}
