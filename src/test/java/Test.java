import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Test extends BrowserStackTestNGTest {

    //WebDriver d;

    @org.testng.annotations.Test
    public void test() {
        //d = super.driver;
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@class = '_3704LK']")).sendKeys("Samsung Galaxy S10" + Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title = 'Mobiles']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class = '_3U-Vxu']/ancestor::section//label"))).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class = '_2id1nE']/span")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() ='Brand']/ancestor::section//label"))).click();
        driver.findElement(By.xpath("//div[@class = '_10UF8M' and contains(text(), 'Price -- High to Low')]")).click();
        WebElement nameOfFirst = driver.findElement(By.xpath("(//div[@class = '_2kHMtA']/a[@class = '_1fQZEK'])[1]//div[@class = '_4rR01T']"));
        try{wait.until(ExpectedConditions.stalenessOf(nameOfFirst));} catch(Exception e){}
        List<WebElement> numberOfResults = driver.findElements(By.xpath("//a[@class = '_1fQZEK']"));
        String [] arrayOfResults = new String[numberOfResults.size()];
        for(int i = 0; i<numberOfResults.size(); i++) {
            String name = driver.findElement(By.xpath("(//div[@class = '_2kHMtA']/a[@class = '_1fQZEK'])["+(i+1)+"]//div[@class = '_4rR01T']")).getText();
            String price = driver.findElement(By.xpath("(//div[@class = '_2kHMtA']/a[@class = '_1fQZEK'])["+(i+1)+"]//div[@class = '_30jeq3 _1_WHN1']")).getText();
            String link = driver.findElement(By.xpath("(//div[@class = '_2kHMtA']/a[@class = '_1fQZEK'])["+(i+1)+"]")).getAttribute("href");
            arrayOfResults[i] = name + " , " + price + " , " + link;
        }
        List <String> listRequired= new ArrayList<String>();
        for (int i = 0; i<arrayOfResults.length; i++){
            listRequired.add(arrayOfResults[i]);
            System.out.println(listRequired.get(i));
        }
        driver.quit();
    }
}
