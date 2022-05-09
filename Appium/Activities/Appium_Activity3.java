package activites;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Appium_Activity3 {
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
		public void addition() throws InterruptedException {
			// Using resource-id
			driver.findElement(MobileBy.id("btn_5_s")).click();
			// Using Accessibility ID
			driver.findElement(MobileBy.AccessibilityId("plus")).click();
			// Using XPath
		   driver.findElement(MobileBy.id("btn_9_s")).click();

			// Perform Calculation
			driver.findElement(MobileBy.AccessibilityId("equals")).click();

			// Display Result
			String result1 = driver.findElement(MobileBy.id("result")).getText().replace("=", "").trim();
			System.out.println(result1);

			// Assertion
			Assert.assertEquals(result1, "14");
			 driver.findElement(MobileBy.id("btn_c_s")).click();
		}
		
		@Test
		public void subtraction() throws InterruptedException {
			// Using resource-id
			driver.findElement(MobileBy.id("btn_1_s")).click();
			driver.findElement(MobileBy.id("btn_0_s")).click();
			// Using Accessibility ID
			driver.findElement(MobileBy.AccessibilityId("minus")).click();
			// Using XPath
		   driver.findElement(MobileBy.id("btn_5_s")).click();

			// Perform Calculation
			driver.findElement(MobileBy.AccessibilityId("equals")).click();

			// Display Result
			String result2 = driver.findElement(MobileBy.id("result")).getText().replace("=", "").trim();
			System.out.println(result2);

			// Assertion
			Assert.assertEquals(result2, "5");
			Thread.sleep(3000);
		}
		
		@Test
		public void multiplication() throws InterruptedException {
			// Using resource-id
			driver.findElement(MobileBy.id("btn_5_s")).click();
			// Using Accessibility ID
			driver.findElement(MobileBy.AccessibilityId("multiply")).click();
			// Using XPath
		   driver.findElement(MobileBy.id("btn_1_s")).click();
		   driver.findElement(MobileBy.id("btn_0_s")).click();
		   driver.findElement(MobileBy.id("btn_0_s")).click();
			// Perform Calculation
			driver.findElement(MobileBy.AccessibilityId("equals")).click();

			// Display Result
			String result3 = driver.findElement(MobileBy.id("result")).getText().replace("=", "").trim();
			System.out.println(result3);

			// Assertion
			Assert.assertEquals(result3, "500");
			 driver.findElement(MobileBy.id("btn_c_s")).click();
		}

		@Test
		public void division() throws InterruptedException {
			// Using resource-id
			driver.findElement(MobileBy.id("btn_5_s")).click();
			driver.findElement(MobileBy.id("btn_0_s")).click();
			// Using Accessibility ID
			driver.findElement(MobileBy.AccessibilityId("divide")).click();
			// Using XPath
		   driver.findElement(MobileBy.id("btn_2_s")).click();
		
			// Perform Calculation
			driver.findElement(MobileBy.AccessibilityId("equals")).click();

			// Display Result
			String result4 = driver.findElement(MobileBy.id("result")).getText().replace("=", "").trim();
			System.out.println(result4);

			// Assertion
			Assert.assertEquals(result4, "25");
			 driver.findElement(MobileBy.id("btn_c_s")).click();
		}

}