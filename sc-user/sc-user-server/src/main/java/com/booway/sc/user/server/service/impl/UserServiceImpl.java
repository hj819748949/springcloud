package com.booway.sc.user.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.booway.sc.user.server.dao.UserDao;
import com.booway.sc.user.server.entity.User;
import com.booway.sc.user.server.service.UserService;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findByAge(int age)
	{
		return userDao.findByAge(age);
	}
}
