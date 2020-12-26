package mavenproject1;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hashmap {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:/Selenium_software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com/");
		
		System.out.println(getCredentialsMap());
		System.out.println(getCredentialsMap().get("seller"));
		//String credentials_customer = getCredentialsMap().get("customer")
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(getusername("seller"));
		driver.findElement(By.name("password")).sendKeys(getpassword("seller"));

        driver.quit();
	}

	public static HashMap<String, String> getCredentialsMap() {
		HashMap<String, String> userMap = new HashMap<String, String>();
		userMap.put("customer", "gagandeep:Test@1234");
		userMap.put("Deliverboy", "Dipen:dipen@1234");
		userMap.put("seller", "vivek:vivek@1234");
		return userMap;
		
		
	}
	public static String getusername(String role) {
		String credentials = getCredentialsMap().get(role);
		return credentials.split(":")[0];
	}
	public static String getpassword(String role) {
		String credentials = getCredentialsMap().get(role);
		return credentials.split(":")[1];

}}
