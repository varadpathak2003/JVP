//javac -cp ".;lib/mysql-connector-j-8.x.x.jar" DBTask.java
//create table users (id int primary key,email varchar(50);
//insert into users value (1,"abc@123.com");

package com.spring.jdbc;
import java.sql.*;
class DBTask extends Thread {
    public void run() {
        String url = "jdbc:mysql://localhost:3306/scm2"; // replace your_database
        String user = "root"; // replace with your DB username
        String pass = ""; // replace with your DB password
        try {
        	 Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String email = rs.getString("email");
                System.out.println(email );
            }
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
public class app {
    public static void main(String[] args) {
        DBTask task = new DBTask(); // Creating thread
        task.start();          
        DBTask task2 = new DBTask(); // Creating thread
        task2.start();         
    }
}
