package com.booway.sc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 负载均衡配置
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Configuration
public class RibbonConfig
{
	/**
	 * 负载均衡调用
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplate()
	{
		return new RestTemplate();
	}
}
