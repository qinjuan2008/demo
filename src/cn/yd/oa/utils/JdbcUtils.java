package cn.yd.oa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// ������Ҫ�����������ݿ⽻��
public class JdbcUtils {
	
	public static void main(String[] args) {
		JdbcUtils utils = new JdbcUtils();
		utils.getConnection();
	}
	
	// �˷���������᷵��һ��Connection����
	public Connection getConnection() {
		try {
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:16608/db", "root", "");
		 
		 return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	// 1: ����: �������ݿ�ʹ�õ�˵����,��ͬ�����ݳ��̻��ṩ�Լ�����������
	// 2: ���������ļ���Դ��xmlֻ��Ҫ����һ��(һ�δ��붼д�ھ�̬��)
	static {
		System.out.println("��̬��,������ص�JVM��ʱ���Զ�ִ����ִ��һ��");
		// ��������: 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
