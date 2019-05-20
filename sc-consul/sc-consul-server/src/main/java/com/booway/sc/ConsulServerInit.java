package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * 注册中心Server初始化
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ConsulServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConsulServerInit.class, args);
	}
}
