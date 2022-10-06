import org.testng.annotations.Test;

import okio.Timeout;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class NewTest {

    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void f() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //scroll down
        JavascriptExecutor Js = ((JavascriptExecutor) driver);
        Js.executeScript("window.scrollBy(0,200)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //clicking on Elements
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@class='category-cards']//div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Clicking on Text box
        driver.findElement(By.xpath("//ul[@class='menu-list']//li")).click();
        //TextBox - Enter Full name
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("userName")).sendKeys("Agron Bajrami");
        //Enter Email
        driver.findElement(By.id("userEmail")).sendKeys("agron.bajrami@gmail.com");
        //Enter Current address
        driver.findElement(By.id("currentAddress")).sendKeys("Partizanski odredi 50, Skopje");
        // Enter permanent address
        driver.findElement(By.id("permanentAddress")).sendKeys("Partizanski odredi 50, Skopje");
        // Click on Submit button - Adding wait
        WebElement submitOver = driver.findElement(By.xpath("//form[@id='userForm']/div[5]"));
        Actions submitoverBuild = new Actions(driver);
        submitoverBuild.moveToElement(submitOver).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement submit = driver.findElement(By.id("submit"));
        Actions submitClick = new Actions(driver);
        submitClick.moveToElement(submit).click().build().perform();

        //Copy submitted details
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String submittedDetais = driver.findElement(By.xpath("//div[@class='mt-4 row']//div[1]")).getText();
        System.out.println(submittedDetais.isEmpty());
        System.out.println(submittedDetais);
        File screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot1, new File("D:\\Exercise\\Screenshots\\DemoQA\\Textbox.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Test(priority = 2)
    public void checkbox() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//ul[@class='menu-list']//li)[2]")).click();
        //Expand all
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        driver.findElement(By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all > svg")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot2, new File("D:\\Exercise\\Screenshots\\DemoQA\\checkbox.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    @Test(priority = 3)
    public void RadioButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@id='item-2']//span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//label[@for='yesRadio']")).click();
        File screenshot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot3, new File("D:\\Exercise\\Screenshots\\DemoQA\\RadioButton.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test(priority = 4)
    public void WebTable() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Selecting Web Table menu

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        WebElement webTableMenu = driver.findElement(By.xpath("(//li[@class='btn btn-light '])[3]"));
        //Using javascriptexecutor
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click()", webTableMenu);

        Thread.sleep(1000);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //clicking on Add button
        driver.findElement(By.id("addNewRecordButton")).click();
        //pop up
        WebElement popUp = driver.findElement(By.xpath("//div[@role='document']//div"));
        Actions popUpHold = new Actions(driver);
        popUpHold.moveToElement(popUp).build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //Filling pop up form
        driver.findElement(By.id("firstName")).sendKeys("Agron");
        driver.findElement(By.id("lastName")).sendKeys("Bajrami");
        driver.findElement(By.id("userEmail")).sendKeys("agron.bajrami@gmail.com");
        driver.findElement(By.id("age")).sendKeys("21");
        driver.findElement(By.id("salary")).sendKeys("50000");
        driver.findElement(By.id("department")).sendKeys("Implementation");
        driver.findElement(By.id("submit")).click();

        File screenshot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot4, new File("D:\\Exercise\\Screenshots\\DemoQA\\WebTable.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Trying to Add existing record
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement clickEdit = driver.findElement(By.cssSelector("#edit-record-1 > svg"));
        clickEdit.click();
        Thread.sleep(1000);
        //Clear already recorded name
        driver.findElement(By.id("firstName")).clear();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //update name
        driver.findElement(By.id("firstName")).sendKeys("Muhamed");
        //click on Submit button
        driver.findElement(By.id("submit")).click();
        //Actions EditButton = new Actions(driver);
        //EditButton.moveToElement(clickEdit).click().build().perform();
        //driver.findElement(By.xpath("///div[contains(@class,'ReactTable -striped')]")).click();

    }

    @Test(priority = 5)
    public void Buttons() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //scroll-down
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0, 300)");

        //Selecting button menu
        driver.findElement(By.xpath("//li[@id='item-4']")).click();

        //Clicking double click
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions dClick = new Actions(driver);
        dClick.moveToElement(doubleClick).doubleClick().build().perform();

        //Click on button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[text()='Click Me']")).click();

        //Right click
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        Actions clickRight = new Actions(driver);
        clickRight.contextClick(rightClick).build().perform();

    }


    @Test(priority = 6)
    public void Links() throws InterruptedException {
	  /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //scroll-down
	  JavascriptExecutor Js = (JavascriptExecutor) driver;
	  Js.executeScript("window.scrollBy(0, 300)");
	  
	  //Selecting button menu - Link
	  driver.findElement(By.xpath("//li[@id='item-5']")).click();
	  
	  //Clicking on link - Browser open in new window
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("simpleLink"));
	  driver.switchTo().defaultContent();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  driver.findElement(By.id("dynamicLink")).click();
	  driver.switchTo().defaultContent();
	*/
    }


    @Test(priority = 7)
    public void BrokenImage() throws InterruptedException {
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
        //Click on Broken Link sub-menu
        WebDriverWait waitBroken = new WebDriverWait(driver, 10);
        waitBroken.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Broken Links - Images']")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='Broken Links - Images']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //Find broken image link on a web page
        try {

            int iBrokenImageCount = 0;
            //List all the elements
            List<WebElement> imgList = driver.findElements(By.tagName("img"));
            System.out.println("Images on the webpage is : " + imgList.size());
            for (WebElement img : imgList) {
                if (img != null) {
                    if (img.getAttribute("naturalWidth").equals("0")) {
                        System.out.println(img.getAttribute("outerHTML") + "broken Image");
                        iBrokenImageCount++;
                    }
                }
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }


    @Test(priority = 8)
    public void BrokenLinks() throws InterruptedException {
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of Links on the web page is :" + links.size());
        for (int i = 0; i < links.size(); i++) {
            WebElement E1 = links.get(i);
            String url = E1.getAttribute("href");
            try {
                verifyLinks(url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    @Test(priority = 9)
    public void BrokenLINKS_LinkScreen() throws InterruptedException, IOException {
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);
	  /*driver.findElement(By.xpath("//li[@id='item-5']")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println("Total number of Links on the current web page is :" +links.size());
	  for (int i = 0; i < links.size(); i++) {
		WebElement E1 = links.get(i);
		String Url = E1.getAttribute("href");
		verifyLinks(Url);
	}*/


    }


    @Test(priority = 10)
    public void download_Upload() throws InterruptedException, IOException {
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);
        WebDriverWait waitE = new WebDriverWait(driver, 10);
        waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='item-7']//span")));
        driver.findElement(By.xpath("//li[@id='item-7']//span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("downloadButton")).click();
        WebElement upload = driver.findElement(By.id("uploadFile"));
        upload.sendKeys("D:\\Exercise\\Images\\imageFile.JPEG");
        File screenshot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot5, new File("D:\\Exercise\\Screenshots\\DemoQA\\downloadANDupload.png"));
    }

    @Test(priority = 11)
    public void DynamicRandom() throws IOException, InterruptedException {
	  /*Thread.sleep(5);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebDriverWait waitF = new WebDriverWait(driver, 10);
	  waitF.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dynamic Properties']")));
	  driver.findElement(By.xpath("//span[text()='Dynamic Properties']")).click();*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement webDynamicClick = driver.findElement(By.xpath("//li[@id='item-8']"));
        JavascriptExecutor Js = (JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click()", webDynamicClick);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait6 = new WebDriverWait(driver, 5);
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("enableAfter")));
        driver.findElement(By.id("colorChange")).click();
        WebDriverWait wait7 = new WebDriverWait(driver, 5);
        wait7.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        driver.findElement(By.id("visibleAfter")).click();

        File screenshot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot6, new File("D:\\Exercise\\Screenshots\\DemoQA\\RandomDynamic.png"));
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @AfterMethod
    public void afterMethod() {
    }

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "D:\\Exercise\\chromedriver\\chromedriver.exe");
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();


    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }

    @BeforeTest()
    public void beforeTest() {
    }

    public static void verifyLinks(String LinkUrl) throws IOException {
        try {

            URL url = new URL(LinkUrl);
            HttpURLConnection HttpURLConnect = (HttpURLConnection) url.openConnection();
            HttpURLConnect.setConnectTimeout(5000);
            HttpURLConnect.connect();
            if (HttpURLConnect.getResponseCode() >= 400) {
                System.out.println(LinkUrl + HttpURLConnect.getResponseMessage() + " broken image");
            } else {
                System.out.println(LinkUrl + HttpURLConnect.getResponseMessage());
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
