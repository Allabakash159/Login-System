package com.pathan.auth;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class UserDAO {
 private String jdbcURL="jdbc:mysql://localhost:3306/logindata";
 private String jdbcUsername="root";
 private String jdbcPassword="Abc1234**";
 
 private static final String VALIDATE_USER_SQL="SELECT * FROM users WHERE username = ? AND password =?";
 public boolean validate(String username, String password) {
	 boolean status=false;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection=DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		 PreparedStatement preparedStatement=connection.prepareStatement(VALIDATE_USER_SQL);
		 preparedStatement.setString(1,username);
		 preparedStatement.setString(2,password);

		 ResultSet rs = preparedStatement.executeQuery();

		 status=rs.next();

		 rs.close();
		 preparedStatement.close();
		 connection.close();
	 }catch(Exception e){
		 e.printStackTrace(System.out);
		 System.out.println("❌ Error: " + e.getMessage());
	 }
	 return status;
 }
 
}
