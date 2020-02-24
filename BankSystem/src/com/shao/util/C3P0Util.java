package com.shao.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//得到一个数据源
	private static ComboPooledDataSource dataSource;
	 public static void initParam() throws PropertyVetoException{
    	 dataSource=new ComboPooledDataSource();           
	        /* 
	         * 设置数据源的各项属性值 
	         */  
	        //数据用户名  
	        dataSource.setUser("root");  
	        //数据库密码  
	        dataSource.setPassword("root");  
	        //数据库连接URL  
	        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/atm");  
	        //数据库连接驱动，注意:必须在项目中导入对应数据库的驱动jar包  
	        dataSource.setDriverClass("com.mysql.jdbc.Driver");  
	        //初始化大小  
	        dataSource.setInitialPoolSize(5);  
	        //最小池大小  
	        dataSource.setMinPoolSize(1);  
	        //最大池大小  
	        dataSource.setMaxPoolSize(10);  
	        dataSource.setMaxStatements(50);  
	        dataSource.setMaxIdleTime(60);  
    }

	
	public static DataSource getDataSource() {
		try {
			initParam();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataSource;
	}

	//从数据源中得到一个连接对象
	public static Connection getConnection() {

		try {
			return getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
}
