package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 配置客户端初始化
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConfigClientInit.class, args);
	}
}
