
import java.sql.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Login_lead_app {
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
public void Login() throws SQLException{
	 String username="user@javachap.com";
		String password_leadapp="javachap";
		boolean valuefound=false;
	try{
		pstmt=conn.prepareStatement("Select * from user where USR_EMAIL=? and USR_PASSWORD=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password_leadapp);
		rs=pstmt.executeQuery();
		valuefound=rs.next();
		
		}catch(Exception e){
			
			
			e.getMessage();
			e.printStackTrace();
			
			
		}
	
	
	
	
	
	
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[1]/div/input")).sendKeys(username);
	
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[2]/div/input")).sendKeys(password_leadapp);
	driver.findElement(By.xpath(".//*[@id='container']/form/ul/li[3]/input")).click();
	String actual_titleofpage=driver.getTitle();
	
	
	// valueFound - True , title->Lead Listing --- Passed
	// valueFound - True, tile-> Login Page -- Failed
	
	// valueFound - False , title->Lead Listing --- Failed
	// valueFound - False, tile-> Login Page -- Passed 
	
	System.out.println(valuefound);
	if(valuefound){
		
		Assert.assertEquals("Lead Listing",actual_titleofpage);
		
		
	}else{
		
		Assert.assertEquals("Login Page", actual_titleofpage);
	}
	
}


		
	
	
	
	


@After
public void closeconne() throws SQLException{
	if(conn!=null && !conn.isClosed()){
		
		conn.close();


}

}
}