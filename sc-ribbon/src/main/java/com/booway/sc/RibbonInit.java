package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ribbon 测试
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(RibbonInit.class, args);
	}
}
