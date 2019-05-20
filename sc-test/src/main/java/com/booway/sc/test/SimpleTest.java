package com.booway.sc.test;

import com.booway.sc.TestInit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 简单测试
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@SpringBootTest(classes = {TestInit.class})
@RunWith(SpringRunner.class)
public class SimpleTest
{
	@Test
	public void test()
	{
		
	}
}
