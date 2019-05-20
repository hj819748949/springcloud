package com.booway.sc.gateway.server.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.booway.sc.common.utils.CommonUtil;

import reactor.core.publisher.Mono;

/**
 * 全局过滤器
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered
{
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
	{
		String token = exchange.getRequest().getQueryParams().getFirst("token");
		if (CommonUtil.isEmpty(token))
		{
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		// 放行
		return chain.filter(exchange);
	}
	@Override
	public int getOrder()
	{
		return 0;
	}
}
