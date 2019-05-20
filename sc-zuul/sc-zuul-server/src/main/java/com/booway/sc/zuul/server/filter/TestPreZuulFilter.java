package com.booway.sc.zuul.server.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月6日
 *
 */
public class TestPreZuulFilter extends ZuulFilter
{
	// 设置该过滤器该不该执行
	@Override
	public boolean shouldFilter()
	{
		RequestContext ctx = RequestContext.getCurrentContext();
		
		// 从上下文中取出变量，决定该不该执行
		return ctx.getBoolean("xx");
	}
	@Override
	public Object run() throws ZuulException
	{
		System.out.println("--------->TestPreZuulFilter");
		
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.setSendZuulResponse(false);
		ctx.setResponseBody("error");
		
		return null;
	}
	@Override
	public String filterType()
	{
		return FilterConstants.PRE_TYPE;
	}
	@Override
	public int filterOrder()
	{
		return 0;
	}
}
