package AutoTrader;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;

import Reports.ScreenShot;
import SpreadSheets.SpreadSheetReader;
import Tests.LoginPage;

public class Auto {

	 private WebDriver webDriver;
	    AutoModel t = new AutoModel();
	    Wait<WebDriver> wait;
	    
	    private static ExtentReports report;
	    private ExtentTest test;
	    private static String reportFilePath = "AutoTraderReport.html";
	    ScreenShot snap = new ScreenShot();
	    

	    @BeforeClass
	    public static void bc() {
	    		report = new ExtentReports();
	        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
	        
	        		//	Name you report here
	        extentHtmlReporter.config().setReportName("AutoTrader Report");
	        extentHtmlReporter.config().setDocumentTitle("AutoTrader Tests");
	        report.attachReporter(extentHtmlReporter);
	    }
	    
	    @Before
	    public void setUp() {
	        System.out.println("Setting up ...");
	        
	        webDriver = new ChromeDriver();
	        
	        t = PageFactory.initElements(webDriver, AutoModel.class);
	        
	        wait = new FluentWait<WebDriver>(webDriver)
					.withTimeout(30, SECONDS)
					.pollingEvery(5, SECONDS)
					.ignoring(NoSuchElementException.class);
	        
	        //test = report.createTest("TestName"); // Do this is each test so named right
	    }

	    @After
	    public void aTest() {
	        System.out.println("Test Complete.");
	        webDriver.quit();
	        
	        //tests.clear();
	        
	    }
	    
	    @AfterClass
	    public static void AfterClass() {
	    		report.flush();
	    }
	
	    
	    @Test
	    public void firstSearch() throws InterruptedException {
		test = report.createTest("Search for Car");
		webDriver.navigate().to("http://www.autotrader.co.uk/");
		webDriver.manage().window().maximize();
		
		
		WebElement waitPostcode = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("postcode"));}});
		t.inputPostcode("BT476FY");
		
		
		//t.inputDistance("30");
		t.checkNearlyNew();
		t.checkUsed();
		
		WebElement waitMake = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("searchVehiclesMake"));}});
		
		t.inputMake("Honda");
		t.inputModel("Civic");
		
		t.inputMinPrice("500");
		
		WebElement waitMax = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("searchVehiclesPriceTo"));}});

		t.inputMaxPrice("1500");
		
		t.clickSearch();
    	
    	
		
	}
	
	    @Test
	public void SearchBMW() throws InterruptedException {
		test = report.createTest("Search for Car w/Excell");
		webDriver.navigate().to("http://www.autotrader.co.uk/");
		webDriver.manage().window().maximize();
		Actions a = new Actions(webDriver);
		SpreadSheetReader ss = new SpreadSheetReader(System.getProperty("user.dir") + "/Book1.xlsx");
   	 	List<String> row1 = ss.readRow(1, "Sheet1");
   	 	
		WebElement waitPostcode = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("postcode"));}});
		t.inputPostcode(row1.get(0));
		
		
		//t.inputDistance(row1.get(1).substring(0,2));
		
		
		t.checkNearlyNew();
		t.checkUsed();
		
		WebElement waitMake = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("searchVehiclesMake"));}});
		
		t.inputMake(row1.get(2));
		t.inputModel(row1.get(3));
		
		t.inputMinPrice(row1.get(4));
		
		WebElement waitMax = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("searchVehiclesPriceTo"));}});

		t.inputMaxPrice(row1.get(5));
		
		t.clickSearch();
    	
		WebElement res = webDriver.findElement(By.cssSelector("section.content-column > div > h2 > a:nth-child(2)"));
		a.moveToElement(res).click().perform();
		
		WebElement text = webDriver.findElement(By.cssSelector("body > div.virtual-vehicle > h1 > span > a"));
		String brand = text.getText().substring(0,3);
		
		assertEquals("BMW", brand);
		test.pass("Brand was BMW");
		
	}
	
	@Test
	public void SearchCorsa() throws InterruptedException {
		test = report.createTest("Search for Car w/Excell");
		webDriver.navigate().to("http://www.autotrader.co.uk/");
		webDriver.manage().window().maximize();
		
		SpreadSheetReader ss = new SpreadSheetReader(System.getProperty("user.dir") + "/Book1.xlsx");
   	 	List<String> row1 = ss.readRow(2, "Sheet1");
   	 	
		WebElement waitPostcode = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("postcode"));}});
		t.inputPostcode(row1.get(0));
		
		
		//t.inputDistance(row1.get(1).substring(0,2));
		
		
		t.checkNearlyNew();
		t.checkUsed();
		
		WebElement waitMake = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("searchVehiclesMake"));}});
		
		t.inputMake(row1.get(2));
		t.inputModel(row1.get(3));
		
		t.inputMinPrice(row1.get(4));
		
		WebElement waitMax = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("searchVehiclesPriceTo"));}});

		t.inputMaxPrice(row1.get(5).substring(0,4));
		
		t.clickSearch();
    	
		TimeUnit.SECONDS.sleep(5);
		test.fail("Failed/ out of bounds");
	}
	
	@Test
	public void SearchStudentReview() throws InterruptedException {
		test = report.createTest("Student Car Reviews");
		webDriver.navigate().to("http://www.autotrader.co.uk/");
		webDriver.manage().window().maximize();
		Actions a = new Actions(webDriver);
		
		t.clickReviews();
		t.clickLatestReviews();
		t.clickStudentReviews();
		
		WebElement text = webDriver.findElement(By.cssSelector("body > main > div:nth-child(7) > div > div > h1"));
		
		
		TimeUnit.SECONDS.sleep(5);
		assertEquals("Best cars for students", text.getText());
		test.pass("Student Review Selected");
	}
	
	@Test
	public void SearchMotorBikeBMW() throws InterruptedException {
		test = report.createTest("Search MotorBike BMW");
		webDriver.navigate().to("http://www.autotrader.co.uk/");
		webDriver.manage().window().maximize();
		Actions a = new Actions(webDriver);
		
		SpreadSheetReader ss = new SpreadSheetReader(System.getProperty("user.dir") + "/Book1.xlsx");
   	 	List<String> row5 = ss.readRow(5, "Sheet1");
   	 	
		t.searchBikesClick();
		WebElement waitPostcode = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.id("postcode"));}});
		t.inputPostcode(row5.get(0));
		
		t.inputDistance(row5.get(1).substring(0,2));
		/*t.checkNearlyNew();
		t.checkUsed();*/
		
		WebElement waitMake = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.name("make"));}});
		
		t.inputBikeMake(row5.get(2));
		t.inputBikeModel(row5.get(3));
		
		t.inputMinCC(row5.get(4));
		t.inputMaxCC(row5.get(5));
		
		TimeUnit.SECONDS.sleep(3);
		t.clickSearch();
		
		WebElement waitres = wait.until(new Function<WebDriver, WebElement>()
		{public WebElement apply(WebDriver webDriver){return webDriver.findElement(By.cssSelector("section.content-column > div > h2 > a:nth-child(2)"));}});
		
		WebElement res = webDriver.findElement(By.cssSelector("section.content-column > div > h2 > a:nth-child(2)"));
		a.moveToElement(res).click().perform();
		
		WebElement text = webDriver.findElement(By.cssSelector("#main-content > div.fpa-header-container > header > h1 > span.pricetitle__advertTitle"));
		String brand = text.getText().substring(0,3);
		
		
		TimeUnit.SECONDS.sleep(2);
		assertEquals("BMW", brand);
		test.pass("Brand was BMW");
		
	}
	
	

}
