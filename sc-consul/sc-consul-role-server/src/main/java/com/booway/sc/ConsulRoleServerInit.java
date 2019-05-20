package com.booway.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 角色ServerInit
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class ConsulRoleServerInit
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConsulRoleServerInit.class, args);
	}
}
