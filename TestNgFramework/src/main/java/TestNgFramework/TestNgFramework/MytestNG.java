package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MytestNG {
	
	WebDriver driver;
	
	@BeforeClass(enabled= false)
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Poorni\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}
	
	@AfterClass(enabled= false)
	public void afterClass() {
		driver.close();
	}
	
	@Test(invocationCount = 1)
	public void  Method1() {
		System.out.println("Executing Test Multiple Times");
	}
	
	@DataProvider(name = "datapassing")
	public Object[][] getData(){
		Object[][] data = TestUtil.getTestData("AccountCreationData");
		return data;
	}
	
	@Test(dataProvider =  "datapassing")
	public void dataProvidertest(String Email,String State,String Zipcode,String Country,String MobilePhone) {
		
		System.out.println("Test Data 1" + Email);
		System.out.println("Test Data 2" + State);
		System.out.println("Test Data 3" + Zipcode);
		System.out.println("Test Data 4" + Country);
		System.out.println("Test Data 5" + MobilePhone);
	}
	
	
	@Test(enabled = false)
	public void Register() {
		
			driver.findElement(By.xpath("//*[@class='login']")).click();
			driver.findElement(By.xpath("//div[@class='form-group']//*[@type='text']")).sendKeys("cpoorni1393@gmail.com");
			driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();//need to check this
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
			driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Poorni");
			driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Cp");
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("ABcd@123");
	
			Select datedrp= new Select(driver.findElement(By.id("days")));
			datedrp.selectByValue("13");
			
			Select monthdrp= new Select(driver.findElement(By.id("months")));
			monthdrp.selectByValue("10");
			
			Select yeardrp= new Select(driver.findElement(By.id("years")));
			monthdrp.selectByValue("1993");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Successful");
		
	}
	
	
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", new Integer(36) },
	   { "Anne", new Integer(37)},
	 };
	}
	 
	//This test method declares that its data should be supplied by the Data Provider
	//named "test1"
	@Test(dataProvider = "test1")
	public void verifyData1(String n1, Integer n2) {
	 System.out.println(n1 + " " + n2);
	}


}
