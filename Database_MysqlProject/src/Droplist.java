
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



public class Droplist {
	WebDriver driver=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	 String url = "jdbc:mysql://localhost:3306/";
	  String dbName = "lead";
	  String driverjdbc = "com.mysql.jdbc.Driver";
	  String userName = "root"; 
	  String password = "sql123";  
	 
	
@Before

public void establishcoonectionwithdatabase(){
	 driver=new FirefoxDriver();
		driver.navigate().to("http://localhost:8080/leadapp/");
	try{
		 Class.forName(driverjdbc).newInstance(); 
		 conn=DriverManager.getConnection(url+dbName,userName,password);
		
	}catch(Exception e){
		
		
		
	}
	
	
}

@Test
public void Login() throws SQLException, InterruptedException{
	 String username="user@javachap.com";
		String password_leadapp="javachap";
		
	
	
	
	
	
	
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[1]/div/input")).sendKeys(username);
	
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[2]/div/input")).sendKeys(password_leadapp);
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[3]/input")).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='container']/div/div/div/a")).click();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='Field7']"));
List<WebElement> actuallistofdropdown=		driver.findElements(By.tagName("option"));
ArrayList<String> actual_stringarray = new ArrayList<>();
System.out.println(actuallistofdropdown.size());
for(int i=1;i<actuallistofdropdown.size();i++){


System.out.println(actuallistofdropdown.get(i).getText());
actual_stringarray.add(actuallistofdropdown.get(i).getText());


}


System.out.println("*****************************");
//fire the query
try{
	pstmt=conn.prepareStatement("Select CT_NAME from category");
	
	rs=pstmt.executeQuery();
	while(rs.next()){
		//System.out.println(actual_stringarray.contains(rs.getString("CT_NAME")));
			//System.out.println(rs.getString("CT_NAME"));
		Assert.assertTrue("value not present"+rs.getString("CT_NAME"),actual_stringarray.contains(rs.getString("CT_NAME")));
		
		
	}
	
	}catch(Exception e){
		
		
		e.getMessage();
		e.printStackTrace();
		
		
	
	
}
	
	
}

}