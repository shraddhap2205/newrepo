import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class extra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String username="user@javachap.com";
			String password_leadapp="javachap";
		WebDriver driver=new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/leadapp/");
		driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[1]/div/input")).sendKeys(username);
		
		driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[2]/div/input")).sendKeys(password_leadapp);
		driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='container']/div/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Field7']"));
List<WebElement> listofdropdown=		driver.findElements(By.tagName("option"));
System.out.println(listofdropdown.size());
for(int i=0;i<listofdropdown.size();i++){
	
	
	System.out.println(listofdropdown.get(i).getText());
	
}
		
		
	}

}
