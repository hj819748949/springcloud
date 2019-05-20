package com.booway.sc.zuul.server.filter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booway.sc.zuul.server.filter.TestErrorZuulFilter;
import com.booway.sc.zuul.server.filter.TestPostZuulFilter;
import com.booway.sc.zuul.server.filter.TestPreZuulFilter;
import com.booway.sc.zuul.server.filter.TestRouteZuulFilter;

/**
 * 配置类
 * @author jsb-hujie
 * 
 * 2019年5月6日
 *
 */
@Configuration
public class ZuulFilterConfig
{
	@Bean
	public TestErrorZuulFilter createTestErrorZuulFilter()
	{
		return new TestErrorZuulFilter();
	}
	@Bean
	public TestPostZuulFilter createTestPostZuulFilter()
	{
		return new TestPostZuulFilter();
	}
	@Bean
	public TestPreZuulFilter createTestPreZuulFilter()
	{
		return new TestPreZuulFilter();
	}
	@Bean
	public TestRouteZuulFilter createTestRouteZuulFilter()
	{
		return new TestRouteZuulFilter();
	}
}
