package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.utils.JdbcUtils;

//此类用来存储访问数据库共性代码，这些代码都需要继承给子类
public class BaseDao {
	public void executeUpdate(String sql,Object[] param) {
		JdbcUtils jdbcUtils = new JdbcUtils();
		Connection conn = jdbcUtils.getConnection();
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				pStatement.setObject(i+1,param[i]);
			}		
			int count = pStatement.executeUpdate();
			System.out.println("更新数据库状态:"+count);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
}
