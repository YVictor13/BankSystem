package com.shao.Service;

import com.shao.model.user;

public interface AccountService {
    
	/**
	 * ע���û�
	 */
	public void addUser(String name,String passsword);
	
	/**
	 * ��¼��֤����ѯ
	 */
	public user check(String name,String password) ;
	
	/**
	 * ת��
	 */
	public void transfer(String FromName,String ToName,double balance);
	
	/**
	 * ���
	 */
	public void update(String name,double balance);
	
	/**
	 * ��ѯ�û�
	 */
	
	public user query(String name) ;
}
