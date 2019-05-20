package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka server
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@EnableEurekaServer
@SpringBootApplication
@EnableAutoConfiguration
public class EurekaServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServerInit.class, args);
	}
}
