package com.booway.sc.gateway.server.filter;

import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

/**
 * 自定义网关过滤器
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
public class CustomGatewayFilter implements GatewayFilter, Ordered
{
	/** 时间flag */
	private static final String TIMEFLAG = "timeflag";
	
	@Override
	public int getOrder()
	{
		return 0;
	}
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
	{
		// 设置初始时间
		exchange.getAttributes().put(TIMEFLAG, System.currentTimeMillis());
		
		// 这里可以写入
		exchange.getResponse().getHeaders().add("xxxxx1", "aaa");
		
		// 只读的不能写入
		// exchange.getRequest().getHeaders().add("xxxxx", "faefer");
		
		// 先调用, 调用完毕后进行简单处理
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			long start = (Long)exchange.getAttributes().get(TIMEFLAG);
			long sub = System.currentTimeMillis() - start;
			System.out.println(sub);
		}));
	}
}
