package com.shao.DAO;

import java.sql.SQLException;

import com.shao.model.user;

public interface accountDAO {
	/**
	 * 登录检验
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public  user query(String name,String password) throws SQLException;
	
	/**
	 * 添加账户
	 * @throws SQLException 
	 */
	public void addUser(String name,String password) throws SQLException;
	
	/**
	 * 更新用户账户信息
	 * @throws SQLException 
	 */
	public void updateAccount(String FromName,String ToName,double balance) throws SQLException;

	/**
	 * 查询账户
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
   public user findUserByName(String name) throws SQLException;


}
