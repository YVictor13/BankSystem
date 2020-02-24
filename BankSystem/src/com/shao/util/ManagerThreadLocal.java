package com.shao.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {
     private static ThreadLocal<Connection> tl = new ThreadLocal<>();
     
     public static Connection getConnection(){
    	 Connection conn = tl.get();
    	 if(conn==null){
    		 conn = C3P0Util.getConnection();
    		 tl.set(conn);
    	 }
    	 return conn;
     }
     
     /**
      * ��������
      */
     public static void startTransaction(){
    	 try {
			getConnection().setAutoCommit(false);//���ÿ�������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /**
      * ����ع�
      */
     public static void rollback(){
    	 try {
			getConnection().rollback();//�ع�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /**
      * �ύ����
      */
     public static void commit(){
    	 try {
			getConnection().commit();//�ع�����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
 	public static void close(){
		try {
			getConnection().close();//�����ӷ������
			tl.remove();//�ͷŵ�ǰ�߳�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  
}
