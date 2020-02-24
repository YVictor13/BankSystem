package com.shao.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//�õ�һ������Դ
	private static ComboPooledDataSource dataSource;
	 public static void initParam() throws PropertyVetoException{
    	 dataSource=new ComboPooledDataSource();           
	        /* 
	         * ��������Դ�ĸ�������ֵ 
	         */  
	        //�����û���  
	        dataSource.setUser("root");  
	        //���ݿ�����  
	        dataSource.setPassword("root");  
	        //���ݿ�����URL  
	        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/atm");  
	        //���ݿ�����������ע��:��������Ŀ�е����Ӧ���ݿ������jar��  
	        dataSource.setDriverClass("com.mysql.jdbc.Driver");  
	        //��ʼ����С  
	        dataSource.setInitialPoolSize(5);  
	        //��С�ش�С  
	        dataSource.setMinPoolSize(1);  
	        //���ش�С  
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

	//������Դ�еõ�һ�����Ӷ���
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
