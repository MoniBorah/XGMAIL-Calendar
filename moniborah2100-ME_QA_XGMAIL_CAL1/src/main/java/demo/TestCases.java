package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
       // driver.close();
      //  driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        Thread.sleep(2000);
        String homepageURL = driver.getCurrentUrl();
        if(homepageURL.contains("calendar")) {
            System.out.println("TestCase01 Passed : WebPage contains the expected URL"); 
        } 
        else {
            System.out.println("TestCase01 Failed : WebPage does not contains the expected URL"); 
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        // driver.get("https://calendar.google.com/");
        // Thread.sleep(2000);

       // WebElement viewButton = driver.findElement(By.xpath("//button[@jsname='jnPWCc']"));
        WebElement viewButton = driver.findElement(By.xpath("//button[@class=\"VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-INsAgc VfPpkd-LgbsSe-OWXEXe-Bz112c-UbuQg VfPpkd-LgbsSe-OWXEXe-dgl2Hf Rj2Mlf OLiIxf PDpWxe LQeN7 j9Fkxf I2n60c\"]"));
        viewButton.click();
       Thread.sleep(2000);
      // WebElement monthButton = driver.findElement(By.xpath("//ul[@jsname='rymPhb']/li[@data-viewkey='month']"));
        WebElement monthButton = driver.findElement(By.xpath("//ul[@class='VfPpkd-StrnGf-rymPhb DMZ54e']//li[3]/span[text()='Month']"));               //ul[@jsname='rymPhb']//li[3]/span[text()='Month']    
        monthButton.click();       
        Thread.sleep(2000);
        WebElement mnth = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        String monthText = mnth.getText();
        if(monthText.contains("Month")) {
            System.out.println("Switched to Month view");
          }
            else {
                System.out.println("Switching to Month view not successful");
            }
        
        Thread.sleep(2000);
        

        WebElement dateButton = driver.findElement(By.xpath("//div[@class='RCXPcd o5s4T']//h2[text()='12']"));
        dateButton.click();
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//div[@aria-label='Monday, February 12']"));
        date.click();
        Thread.sleep(2000);

        WebElement taskButton = driver.findElement(By.xpath("//div[@jsname='SF0uGd']//div[3]/div[1]/button[2]/div[text()='Task']"));
        taskButton.click();
        Thread.sleep(2000);
        // final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sY9Vnd a5K8d bRcSk']")));
        WebElement addTitle = driver.findElement(By.xpath("//div[@jsname='SF0uGd']//input[@aria-label='Add title and time']"));
        addTitle.click();
        addTitle.sendKeys("Crio INTV Task Automation");
        Actions action = new Actions(driver);
        WebElement addDesc = driver.findElement(By.xpath("//div[@class='Ufn6O DTMIOb rhoNuf hpykHb']/label/textarea[@class='VfPpkd-fmcmS-wGMbrd TaTzUd']"));
        action.moveToElement(addDesc).click();
        WebElement desc = driver.findElement(By.xpath("//div[@class='Ufn6O DTMIOb rhoNuf hpykHb']/label/textarea[@class='VfPpkd-fmcmS-wGMbrd TaTzUd']"));
        desc.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(2000);
        WebElement save = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']"));
        save.click();
        Thread.sleep(2000);

        WebElement task = driver.findElement(By.xpath("//div[@class='KF4T6b jKgTF QGRmIf']/span/span[text()='Crio INTV Task Automation']"));
        String taskText = task.getText();
        if(taskText.equals("Crio INTV Task Automation")) {
            System.out.println("Task is created");
        } else {
            System.out.println("Task not created");
        }
        

        System.out.println("end Test case: testCase02");
    
    }
    
    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        // driver.get("https://calendar.google.com/");
        // Thread.sleep(2000);

        WebElement task = driver.findElement(By.xpath("//div[@class='KF4T6b jKgTF QGRmIf']/span/span[@class='WBi6vc']"));
        task.click();
        Thread.sleep(2000);
        WebElement editTask = driver.findElement(By.xpath("//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc m2yD4b HfYfLe']//span[@class='VfPpkd-kBDsod meh4fc KU3dEf']"));
        editTask.click();
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        WebElement updateDesc = driver.findElement(By.xpath("//div[@class='AIEc0c']/div/div/label/textarea[@class='VfPpkd-fmcmS-wGMbrd vRGQ0d']"));         //input[@placeholder='Add title']
        action.moveToElement(updateDesc).click().build().perform();
        updateDesc.clear();
        updateDesc.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(2000);

        WebElement saveButton = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7']"));
        saveButton.click();
        Thread.sleep(2000);

        WebElement tsk = driver.findElement(By.xpath("//div[@class='KF4T6b jKgTF QGRmIf']/span/span[text()='Crio INTV Task Automation']"));
        tsk.click();
        Thread.sleep(2000);
        WebElement updatedDesc = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
        String updatedDescText = updatedDesc.getText();
        String newDesc = updatedDescText.replace("Description:","");
        System.out.println(newDesc);
        if(newDesc.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")) {

            System.out.println("Task description successfully updated and displayed");
        } else {
            System.out.println("Failed to update task description.");
        }

        // String updatedDesc = inputButton.getAttribute("value");
        // if (updatedDesc.isDisplayed()) {
        //     System.out.println("Task description successfully updated and displayed");
        // } else {
        //     System.out.println("Failed to update task description.");
        // }

        System.out.println("end Test case: testCase03"); 

    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        //  driver.get("https://calendar.google.com/");
        //  Thread.sleep(2000);

        // WebElement task = driver.findElement(By.xpath("//div[@class='KF4T6b jKgTF QGRmIf']/span/span[@class='WBi6vc']"));                         //span[contains(text(),'Crio INTV Task Automation')]
        // task.click();
        // Thread.sleep(2000);
        WebElement titleDetails = driver.findElement(By.xpath("//span[@id='rAECCd']"));
        String titleDetailsText = titleDetails.getText();
        if(titleDetailsText.equals("Crio INTV Task Automation")) {
            System.out.println("Task description successfully verified.");
        } else {
            System.out.println("Failed to verify task description.");
        }  
        
        WebElement deleteTask = driver.findElement(By.xpath("//button[@jsname='VkLyEc']"));
        deleteTask.click();
        Thread.sleep(2000);

        //  final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='YrbPvc']")));
        // String deletePopup = driver.findElement(By.xpath("//div[@class='VYTiVb'and text()='Task deleted']")).getText();
       // boolean deletePopup = driver.findElement(By.xpath("//div[@class='VYTiVb'and text()='Task deleted']")).isDisplayed();
        //WebElement popupText = deletePopup.findElement(By.xpath("//div[contains(text(),'Event deleted')]"));
       // String deletePopupText = deletePopup.getText();
       // System.out.println(deletePopupText);
       // if(deletePopupText.contains("Event deleted")) {


        // WebElement deletePopup = driver.findElement(By.xpath("//div[@class='VYTiVb'and text()='Task deleted']"));
        // String popupText = deletePopup.getText();

        // System.out.println(deletePopup);
        // if(deletePopup.equals("Task deleted")) {
        //     System.out.println("Task deleted is displayed");
        // } 
        // else {
        //     System.out.println("Task deletion not displayed");
        // }
        
        WebElement popup = driver.findElement(By.xpath("//div[@class='VYTiVb'and text()='Task deleted']"));
        System.out.println(popup.getText());
        if(popup.getText().contains("Task deleted")){
               
            System.out.println("The alert text is equal to Task deleted");
        }
        else{
            System.out.println("TestCase04 failed");
        }
        

        System.out.println("end Test case: testCase04"); 

    }
     
}
