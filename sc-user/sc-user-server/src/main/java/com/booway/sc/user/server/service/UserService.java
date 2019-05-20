package com.booway.sc.user.server.service;

import java.util.List;

import com.booway.sc.user.server.entity.User;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
public interface UserService
{
	/**
	 * 根据年龄查询
	 * @param age
	 * @return
	 */
	List<User> findByAge(int age);
}
