package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试启动类
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TestInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(TestInit.class, args);
	}
}
