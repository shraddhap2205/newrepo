
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Create_NewLead {
	WebDriver driver=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	 String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "lead";
	  String driverjdbc = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "sql123";  
	  String qk="12345";
	  String qk1="12345";
	 //commit thid
	 
	
@Before

public void establishcoonectionwithdatabase(){
	 driver=new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/leadapp/");
	try{
		 Class.forName(driverjdbc).newInstance(); 
		 conn=DriverManager.getConnection(url+dbName,userName,password);
		
	}catch(Exception e){
		
		System.out.println("s");
		
	}
	
	
}

@Test
public void Login() throws SQLException, InterruptedException{
	 String username="user@javachap.com";
		String password_leadapp="javachap";
		
	
	String category="Insurance";
	String Title="Lead-Title for selling car";
	String Description="bla bla";
	String firstname="rahul";
	String lastname="gandhi";
	String email="rahul@gmail.com";
	String phone="232";
	String price="2000";
	
	
	
	
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[1]/div/input")).sendKeys(username);
	
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[2]/div/input")).sendKeys(password_leadapp);
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[3]/input")).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='container']/div/div/div/a")).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='Field7']")).sendKeys(category);
	driver.findElement(By.xpath(".//*[@id='Field0']")).sendKeys(Title);
	driver.findElement(By.xpath(".//*[@id='Field1']")).sendKeys(Description);
	driver.findElement(By.xpath(".//*[@id='Field4']")).sendKeys(firstname);
	driver.findElement(By.xpath(".//*[@id='Field5']")).sendKeys(lastname);
	driver.findElement(By.xpath(".//*[@id='Field6']")).sendKeys(email);
	driver.findElement(By.xpath(".//*[@id='Field8']")).sendKeys(phone);
	driver.findElement(By.xpath(".//*[@id='Field9']")).sendKeys(price);
	driver.findElement(By.xpath(".//*[@id='saveForm']")).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	
	
	try{
		
		pstmt=conn.prepareStatement("select * from lead where LD_TITLE=?");
		pstmt.setString(1, Title);
		rs=pstmt.executeQuery();
		//Check whether record is inserted
		
		
		Assert.assertTrue("Record deos not exist", rs.next());
		
		//Check the records
		Assert.assertEquals(Title,rs.getString("LD_TITLE"));
		Assert.assertEquals(Description,rs.getString("LD_DESCRIPTION"));
	}catch(Exception e){
		
		
		
		
	}
	
}

}