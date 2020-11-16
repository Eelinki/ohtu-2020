package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(1);
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(1);

        Random r = new Random();

        element = driver.findElement(By.name("username"));

        String username = "test" + r.nextInt(100000);

        element.sendKeys(username);

        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana123");

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana123");

        element = driver.findElement(By.name("signup"));
        
        sleep(1);
        element.submit();

        sleep(1);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(1);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(1);

        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(1);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);

        element = driver.findElement(By.name("password"));
        element.sendKeys("fail4321");

        element = driver.findElement(By.name("login"));

        sleep(1);

        element.submit();

        sleep(2);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
