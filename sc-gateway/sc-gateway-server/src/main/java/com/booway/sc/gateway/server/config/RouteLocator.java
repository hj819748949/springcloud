package com.booway.sc.gateway.server.config;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.booway.sc.gateway.server.filter.CustomGatewayFilter;

/**
 * 路由信息加载器
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
@Configuration
public class RouteLocator
{
	/**
	 * 设置路由信息
	 * @return
	 */
	@Bean
	public org.springframework.cloud.gateway.route.RouteLocator createRouteLocator(RouteLocatorBuilder builder)
	{
		org.springframework.cloud.gateway.route.RouteLocator rt = 
				builder.routes()
					   .route(r -> r.path("/service/user/queryById")
							        .filters(f -> f.filter(new CustomGatewayFilter()))
				                    .uri("http://localhost:8087/")
				                    .order(0)
									.id("service-user"))
					   .build();
		return rt;
	}
}
