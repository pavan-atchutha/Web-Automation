package newproject;
import java.util.*;
import java.lang.*;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver; // Import the EdgeDriver class
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Myclass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\pavan\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        // Navigate to the MakeMyTrip railways page
       driver.get("https://www.makemytrip.com/railways/");
        
//        
//        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
////        wait.until(ExpectedConditions.titleContains("IRCTC Train Booking"));
//       // Thread.sleep(2000);
//        
//        // Verify the page title
//        if (driver.getTitle().contains("IRCTC Train Booking")) {
//            System.out.println("Landed on the correct page.");
//        } else {
//            System.out.println("Not on the expected page.");
//        }
//       
//        // Print URL and Title
//        System.out.println("Current URL: " + driver.getCurrentUrl());
//        System.out.println("Current Title: " + driver.getTitle());
//        Thread.sleep(5000);
//        // Click on FROM
//        WebElement fromField = driver.findElement(By.id("fromCity"));
//        fromField.click();
//        fromField.sendKeys("DELHI");
//        Thread.sleep(5000);
//        // Click on TO
//        WebElement toField = driver.findElement(By.id("toCity"));
//        toField.click();
//        toField.sendKeys("LUCKNOW");
//        Thread.sleep(5000);
//        // Select Travel Date
//        WebElement travelDate = driver.findElement(By.id("travelDate"));
//        travelDate.click();
//        WebElement date = driver.findElement(By.xpath("//div[text()='25']"));
//        date.click();
//
//        Thread.sleep(5000);
//        
//        // Select Class
//        WebElement classDropdown = driver.findElement(By.id("travelFor"));
//        Select selectClass = new Select(classDropdown);
//        selectClass.selectByVisibleText("Third AC");
//
//        // Click on SEARCH Button
//        WebElement searchButton = driver.findElement(By.id("trainFormButton"));
//        searchButton.click();
//
//        // Wait for results to load and perform further actions
//
//        // Close the browser
//        driver.quit();
    // Check if the correct page has been loaded
       // Check if the correct page has been loaded
       String url = driver.getCurrentUrl();
       String title = driver.getTitle();
       System.out.println("URL: " + url);
       System.out.println("Title: " + title);
       Thread.sleep(5000);
       // Enter the source city
       WebElement fromCityElement = driver.findElement(By.id("fromCity"));
       fromCityElement.click();

       // Get the list of cities from the drop down list
      // WebElement cityListElement = driver.findElement(By.className("react-autosuggest__suggestions-list"));
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement cityListElement = wait.until(
           element -> element.findElement(By.className("react-autosuggest__suggestions-list"))
       );
       List<WebElement> cityElements = cityListElement.findElements(By.tagName("li"));

       // Select the city from the list
       for (WebElement cityElement : cityElements) {
           if (cityElement.getText().equals("DELHI")) {
               cityElement.click();
               break;
           }
       }

       // Enter the destination city
       WebElement toCityElement = driver.findElement(By.id("toCity"));
       toCityElement.click();

       // Get the list of cities from the dropdown list
       //WebElement cityListElement1 = driver.findElement(By.id("toCity_listbox"));
       WebElement cityListElement1 = wait.until(
               element -> element.findElement(By.className("react-autosuggest__suggestions-list"))
           );
       List<WebElement> cityElements1 = cityListElement1.findElements(By.tagName("li"));

       // Select the city from the list
       for (WebElement cityElement1 : cityElements1) {
           if (cityElement1.getText().equals("LUCKNOW")) {
               cityElement1.click();
               break;
           }
       }

       // Select the travel date
       WebElement travelDateElement = driver.findElement(By.id("travelDate"));
       travelDateElement.click();
       WebElement calendar = wait.until(
               element -> element.findElement(By.xpath("//div[@class='cal']"))
           );
       WebElement dateElement = calendar.findElement(By.xpath("//td[text()='26 Aug']"));

       //driver.findElement(By.xpath("//td[text()='20 May']")).click();
       dateElement.click();
       // Select the class
       WebElement classElement = driver.findElement(By.id("class"));
       classElement.click();
       driver.findElement(By.xpath("//option[text()='Third AC']")).click();

       // Click on the Search button
       WebElement searchButton = driver.findElement(By.id("searchBtn"));
       searchButton.click();
       
       // Close the browser
       driver.quit();
    }
}

