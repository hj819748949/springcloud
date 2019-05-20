package com.booway.sc.zuul.server.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月6日
 *
 */
public class TestPostZuulFilter extends ZuulFilter
{
	@Override
	public boolean shouldFilter()
	{
		return true;
	}
	@Override
	public Object run() throws ZuulException
	{
		System.out.println("--------->TestPostZuulFilter");
		return null;
	}
	@Override
	public String filterType()
	{
		return FilterConstants.POST_TYPE;
	}
	@Override
	public int filterOrder()
	{
		return 0;
	}
}
