package cn.yd.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// 此类主要是用于与数据库交互
public class JdbcUtils {
	
	public static void main(String[] args) {
		JdbcUtils utils = new JdbcUtils();
		utils.getConnection();
	}
	
	// 此方法调用则会返回一个Connection对象
	public Connection getConnection() {
		try {
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:16608/db", "root", "");
		 
		 return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 1: 驱动: 就是数据库使用的说明书,不同的数据厂商会提供自己的驱动程序
	// 2: 驱动程序、文件资源、xml只需要加载一次(一次代码都写在静态块)
	static {
		System.out.println("静态块,此类加载到JVM中时会自动执行且执行一次");
		// 加载驱动: 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
