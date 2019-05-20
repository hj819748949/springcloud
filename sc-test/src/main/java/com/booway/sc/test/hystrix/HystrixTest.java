package com.booway.sc.test.hystrix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.booway.sc.TestInit;
import com.booway.sc.user.client.UserClient;

/**
 * 测试
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@SpringBootTest(classes = { TestInit.class })
@RunWith(SpringRunner.class)
public class HystrixTest
{
	/** 调用feign的客户端 */
	@Autowired
	private UserClient userClient;
	
	/**
	 * 进入熔断器
	 */
	@Test
	public void testHystrix0()
	{
		String str = userClient.testhystrix(0);
		System.out.println(str);
	}
	/**
	 * 不进入熔断器
	 */
	@Test
	public void testHystrix1()
	{
		String str = userClient.testhystrix(1);
		System.out.println(str);
	}
}
