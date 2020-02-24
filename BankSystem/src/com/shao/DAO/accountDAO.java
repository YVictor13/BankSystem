package com.shao.DAO;

import java.sql.SQLException;

import com.shao.model.user;

public interface accountDAO {
	/**
	 * ��¼����
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public  user query(String name,String password) throws SQLException;
	
	/**
	 * ����˻�
	 * @throws SQLException 
	 */
	public void addUser(String name,String password) throws SQLException;
	
	/**
	 * �����û��˻���Ϣ
	 * @throws SQLException 
	 */
	public void updateAccount(String FromName,String ToName,double balance) throws SQLException;

	/**
	 * ��ѯ�˻�
	 * @param name
	 * @return
	 * @throws SQLException 
	 */
   public user findUserByName(String name) throws SQLException;


}
