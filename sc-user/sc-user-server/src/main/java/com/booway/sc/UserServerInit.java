package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户启动初始化
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class UserServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(UserServerInit.class, args);
	}
}
