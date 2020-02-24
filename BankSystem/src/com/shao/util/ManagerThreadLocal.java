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
      * 开启事务
      */
     public static void startTransaction(){
    	 try {
			getConnection().setAutoCommit(false);//设置开启事务
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /**
      * 事务回滚
      */
     public static void rollback(){
    	 try {
			getConnection().rollback();//回滚事务
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
     /**
      * 提交事务
      */
     public static void commit(){
    	 try {
			getConnection().commit();//回滚事务
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     
 	public static void close(){
		try {
			getConnection().close();//把连接放入池里
			tl.remove();//释放当前线程
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  
}
