//import mysql package
import java.sql.*;
public class JDBC_Connection {

	public static void main(String[] args) throws SQLException {
		//REFERENCE OF Connection Interface
		Connection conn = null;
		  String url = "jdbc:mysql://localhost:3306/";
		  String dbName = "test";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "root"; 
		  String password = "sql123";  
		  //Statement Usage
		  
		  try{
			  
			  //This will create the object of driver
			  //This line constant for every DATABASE
			 Class.forName(driver).newInstance(); 
			
			 //Connection will be extablished
			 conn=DriverManager.getConnection(url+dbName,userName,password);
			 
			 //By calling CreateStatemet funcion on Connection Interface u ll return Statement Interface ref
			/* Statement stmt=conn.createStatement();
			 
			 //oN Statement Reference u can call executequery() function
			 ResultSet rs=stmt.executeQuery("select * from persons");
			 
			 //Cursor will point to 1 row in the resultset
			 //rs.next();
			 //System.out.println(rs.getString("LastName"));
			 //u can give column no
			// System.out.println(rs.getString(3));
			// rs.next();
			// System.out.println(rs.getString("PersonID"));
			 
			 //How to print complete table
			 while(rs.next()){
				 System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getString(4)+"--"+rs.getString(5));
				 			 			 
			 }*/

			  System.out.println("*********************************");
			
			 //Callable statement
			//CallableStatement cstmt = conn.prepareCall("{call getTestData(?,?,?,?)}");
			    //cstmt.registerOutParameter(1, java.sql.Types.DECIMAL, 3);
			    //cstmt.setString(2, "xxxxx");
			    
			    
			    //cstmt.executeUpdate();
			   // double d =cstmt.getDouble(1);
			 
			 
			 //*********************Addrow
			  PreparedStatement pstmt=conn.prepareStatement("insert into persons values(?,?,?,?,?)");
			 pstmt.setString(1, "5");
			 pstmt.setString(2, "Zalke");
			 pstmt.setString(3, "piyu");
			 pstmt.setString(4, "Dombivili");
			 pstmt.setString(5, "MUMBAI");
			 
			 int i=pstmt.executeUpdate();
			 if(i==1){
				 
				 
				 System.out.println("Record inserted");
			 }
			 
			 
			//Prepared Statement 
			 
				 pstmt = conn.prepareStatement("select * from persons where PersonID = ? and LastName=?");
				  pstmt.setString(1, "3");
				  pstmt.setString(2, "PARKAR");
				  ResultSet rs1 = pstmt.executeQuery();
				  
				  while(rs1.next()){
						System.out.println(rs1.getString(1)+rs1.getString(2)+rs1.getString(3)+rs1.getString(4)+rs1.getString(5));  
				  }			 
				  
				 
		  }catch(Exception e){
			  e.printStackTrace();
			  
			  
		  }finally{
			  conn.close();
			  
		  }

	}

}
