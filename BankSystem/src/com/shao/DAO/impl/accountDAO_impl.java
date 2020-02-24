package com.shao.DAO.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.shao.DAO.accountDAO;
import com.shao.model.user;
import com.shao.util.C3P0Util;
import com.shao.util.ManagerThreadLocal;
public class accountDAO_impl implements accountDAO{

	@Override
	public user query(String name, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		return qr.query(ManagerThreadLocal.getConnection(), "select * from bank where name = ? and password = ?",new BeanHandler<user>(user.class), name,password);
	}

	@Override
	public void addUser(String name, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into bank (name,password,balance) values (?,?,?)",name,password,0);
		
	}

	@Override
	public void updateAccount(String FromName, String ToName, double balance) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(),"update bank set balance =balance - ? where name = ?",balance,FromName);
		qr.update(ManagerThreadLocal.getConnection(),"update bank set balance =balance + ? where name = ?",balance,ToName);
	}
	
	public void updateAccount(String name,double balance) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(),"update bank set balance = ? where name = ? ",balance,name);
	}

	@Override
	public user findUserByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		return qr.query(ManagerThreadLocal.getConnection(), "select * from bank where name = ?",new BeanHandler<user>(user.class), name);
	}
	
	
	

}
