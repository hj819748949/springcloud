package com.booway.sc.consul.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 客户端工具类
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@RestController
@RefreshScope
@RequestMapping("/consulclient/test")
public class ConsulClientController
{
	// @Autowired
	// private RoleClient roleClient;
	
	@Value("${sc.xx}")
	private String val;
	
	@GetMapping("/test")
	public String test()
	{
		// int rs = roleClient.add(4, 10);
		// System.out.println(rs);
		System.out.println(val);
		return "SUCCESS";
	}
}
