package activites;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class Appium_Activity1 {

	// Declare Android driver
	AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "fc3e29dd1220");
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.miui.calculator");
		caps.setCapability("appActivity", ".cal.CalculatorActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AndroidDriver<>(appServer, caps);
	}

	@Test
	public void multiply() {
		// Using resource-id
		driver.findElement(MobileBy.id("btn_9_s")).click();
		// Using Accessibility ID
		driver.findElement(MobileBy.AccessibilityId("multiply")).click();
		// Using XPath
	   driver.findElement(MobileBy.id("btn_5_s")).click();

		// Perform Calculation
		driver.findElement(MobileBy.AccessibilityId("equals")).click();

		// Display Result
		String result = driver.findElement(MobileBy.id("result")).getText().replace("=", "").trim();
		System.out.println(result);

		// Assertion
		Assert.assertEquals(result, "45");
	}

	@AfterClass
	public void tearDown() {
		// Close app
		driver.quit();
	}
}