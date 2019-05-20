package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关服务器初始化, 跟gateway是一个性质的东西
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(ZuulServerInit.class, args);
	}
}
