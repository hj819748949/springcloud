package com.booway.sc.guava;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 阅读限流相关的代码
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
public class GuavaTest
{
	@Test
	public void testRateLimiter()
	{
		// 指定每秒的许可数量(QPS)
		RateLimiter rateLimiter = RateLimiter.create(1);
		if (!rateLimiter.tryAcquire())
		{
			// 限流中
			
		} else 
		{
			// 正常通行
			
		}
	}
}
