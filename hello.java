package task13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

		public class hello {

	 public static void main(String[] args) {

		        
		        
		        WebDriver driver = new ChromeDriver();

		        driver.get("https://the-internet.herokuapp.com/iframe");
		        
		        driver.switchTo().frame(driver.findElement(By.cssSelector("#mce_0_ifr")));

		        WebElement pTag = driver.findElement(By.id("tinymce"));
		        
		        pTag.clear();
		        
		        pTag.sendKeys("Hello people");

		        
		        String text = pTag.getText();
		        
		        if ("Hello people".equals(text)) 
		        
		        {
		            System.out.println("Text set successfully: " + text);
		        } 
		        else 
		        {
		            System.out.println("Text setting failed. Current text: " + text);
		        }

		        
		        //driver.quit();
		    }
		

	}

