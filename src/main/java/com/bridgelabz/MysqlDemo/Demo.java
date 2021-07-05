package com.bridgelabz.MysqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Enumeration;
//import java.sql.DriverManager.getDrivers;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;

public class Demo {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/employee_payroll?useSSL=false";
		String userName = "root";
		String password = "root";
		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("cannot find driver in classpath", e);
		}

		listDrivers();
		try {
			System.out.println("Conncting to databse:" + jdbcURL);
			connection = DriverManager.getConnection(jdbcURL, userName, password);
			System.out.println("connection is successful" + connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (((Enumeration<?>) driverList).hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());

		}
	}

}
