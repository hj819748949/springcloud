package com.booway.sc.user.server.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booway.sc.user.server.entity.User;

/**
 * 用户DAO
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
public interface UserDao extends JpaRepository<User, Long>
{
	/**
	 * 根据年龄查询
	 * @param age
	 * @return
	 */
	List<User> findByAge(int age);
}
