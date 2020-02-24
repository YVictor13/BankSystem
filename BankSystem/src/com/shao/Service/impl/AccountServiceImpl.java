package com.shao.Service.impl;


import java.sql.SQLException;

import com.shao.DAO.impl.accountDAO_impl;
import com.shao.Service.AccountService;
import com.shao.model.user;
import com.shao.util.ManagerThreadLocal;

public class AccountServiceImpl implements AccountService{
  
	accountDAO_impl account = new accountDAO_impl();
	@Override
	public void addUser(String name,String password) {
		// TODO Auto-generated method stub
		try {
			ManagerThreadLocal.startTransaction();
			account.addUser(name,password);
			ManagerThreadLocal.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ManagerThreadLocal.rollback();
		} finally{
			ManagerThreadLocal.close();
		}
	}

	@Override
	public user query(String name) {
		// TODO Auto-generated method stub
		user u = new user();
		try {
			ManagerThreadLocal.startTransaction();
			u = account.findUserByName(name);
			ManagerThreadLocal.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ManagerThreadLocal.rollback();
		}finally{
			ManagerThreadLocal.close();
		}
		return u;
	}

	@Override
	public void update(String name, double balance) {
		// TODO Auto-generated method stub
		user u = new user();
		try {
			ManagerThreadLocal.startTransaction();
			account.updateAccount(name,balance);
			ManagerThreadLocal.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ManagerThreadLocal.rollback();
		}finally{
			ManagerThreadLocal.close();
		}
	}
	

	@Override
	public void transfer(String FromName, String ToName, double balance) {
		// TODO Auto-generated method stub
		try {
			ManagerThreadLocal.startTransaction();
			user u_from = account.findUserByName(FromName);
			user u_to = account.findUserByName(ToName);
			
			u_from.setbalance(u_from.getbalance()-balance);
			u_to.setbalance(u_to.getbalance()+balance);
			
			account.updateAccount(FromName,u_from.getbalance());
			account.updateAccount(ToName,u_to.getbalance());
			ManagerThreadLocal.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ManagerThreadLocal.rollback();
		}finally{
			ManagerThreadLocal.close();
		}				
	}

	@Override
	public user check(String name, String password) {
		// TODO Auto-generated method stub
		user u = new user();
		try {
			ManagerThreadLocal.startTransaction();
			u = account.query(name,password);
			ManagerThreadLocal.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ManagerThreadLocal.rollback();
		}finally{
			ManagerThreadLocal.close();
		}
		return u;
	}


	
	
    
}
