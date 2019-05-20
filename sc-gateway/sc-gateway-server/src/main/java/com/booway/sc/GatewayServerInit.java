package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * 网关Server
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class GatewayServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(GatewayServerInit.class, args);
	}
}
