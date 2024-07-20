package task13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class frames {
    
    public static void main(String[] args) {
        
        
        WebDriver driver = new ChromeDriver();
        
        // Open the URL
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        
        // Maximize the window
        driver.manage().window().maximize();
        
        // Switch to the top frame
        driver.switchTo().frame("frame-top");
        
        // Verify that there are three frames on the page
        List<WebElement> frames = driver.findElements(By.cssSelector("frame"));
        if (frames.size() == 3) {
            System.out.println("Verification successful: There are three frames on the page.");
        } else {
            System.out.println("Verification failed: There are not three frames on the page.");
        }
        
        // Switch to the left frame
        driver.switchTo().frame("frame-left");
        
        // Verify the left frame has the text "LEFT"
        WebElement leftFrameText = driver.findElement(By.cssSelector("body"));
        if (leftFrameText.getText().equals("LEFT")) {
            System.out.println("Verification successful: The left frame has the text 'LEFT'.");
        } else {
            System.out.println("Verification failed: The left frame does not have the text 'LEFT'.");
        }
        
        // Switch back to the top frame
        driver.switchTo().parentFrame();
        
        // Switch to the middle frame
        driver.switchTo().frame("frame-middle");
        
        // Verify the middle frame has the text "MIDDLE"
        WebElement middleFrameText = driver.findElement(By.cssSelector("div#content"));
        if (middleFrameText.getText().equals("MIDDLE")) {
            System.out.println("Verification successful: The middle frame has the text 'MIDDLE'.");
        } else {
            System.out.println("Verification failed: The middle frame does not have the text 'MIDDLE'.");
        }
        
        // Switch back to the top frame
        driver.switchTo().parentFrame();
        
        // Switch to the right frame
        driver.switchTo().frame("frame-right");
        
        // Verify the right frame has the text "RIGHT"
        WebElement rightFrameText = driver.findElement(By.cssSelector("body"));
        if (rightFrameText.getText().equals("RIGHT")) {
            System.out.println("Verification successful: The right frame has the text 'RIGHT'.");
        } else {
            System.out.println("Verification failed: The right frame does not have the text 'RIGHT'.");
        }
        
        // Switch back to the top frame
        driver.switchTo().parentFrame();
        
        // Switch back to the main page
        driver.switchTo().defaultContent();
        
        // Switch to the bottom frame
        driver.switchTo().frame("frame-bottom");
        
        // Verify the bottom frame has the text "BOTTOM"
        WebElement bottomFrameText = driver.findElement(By.cssSelector("body"));
        if (bottomFrameText.getText().equals("BOTTOM")) {
            System.out.println("Verification successful: The bottom frame has the text 'BOTTOM'.");
        } else {
            System.out.println("Verification failed: The bottom frame does not have the text 'BOTTOM'.");
        }
        
     // Verify the title of the page is "Frames"
        String expectedTitle = "Frames";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Verification successful: The title of the page is 'Frames'.");
        } else {
            System.out.println("Verification failed: The title of the page is not 'Frames'.");
        }
       
    }
}

