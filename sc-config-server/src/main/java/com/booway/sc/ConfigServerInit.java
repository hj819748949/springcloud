package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心初始化
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigServerInit.class, args);
	}
}
