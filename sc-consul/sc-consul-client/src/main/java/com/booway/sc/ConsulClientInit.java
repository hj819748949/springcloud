package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * consul客户端初始化
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
// @EnableFeignClients
public class ConsulClientInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConsulClientInit.class, args);
	}
}
