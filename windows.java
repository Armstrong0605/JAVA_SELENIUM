package task13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class windows {
    
    public static void main (String[] args) {
        
       
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://the-internet.herokuapp.com/windows");
        
        driver.manage().window().maximize();
        
       String originalWindow = driver.getWindowHandle();
        
        driver.findElement(By.xpath("//a[@href='/windows/new' and @target='_blank' and text()='Click Here']")).click();
        
        Set<String> allWindows = driver.getWindowHandles();
        
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        if (newWindowText.getText().equals("New Window")) {
            System.out.println("Verification successful: 'New Window' is present on the page.");
        } else {
            System.out.println("Verification failed: 'New Window' is not present on the page.");
        }
       
        driver.close();
        
        driver.switchTo().window(originalWindow);
        
        if (driver.getWindowHandle().equals(originalWindow)) {
            System.out.println("Verification successful: The original window is active.");
        } else {
            System.out.println("Verification failed: The original window is not active.");
        }
        //driver.quit();
    }
}
