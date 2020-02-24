package com.shao.Service;

import com.shao.model.user;

public interface AccountService {
    
	/**
	 * 注册用户
	 */
	public void addUser(String name,String passsword);
	
	/**
	 * 登录验证，查询
	 */
	public user check(String name,String password) ;
	
	/**
	 * 转账
	 */
	public void transfer(String FromName,String ToName,double balance);
	
	/**
	 * 存款
	 */
	public void update(String name,double balance);
	
	/**
	 * 查询用户
	 */
	
	public user query(String name) ;
}
