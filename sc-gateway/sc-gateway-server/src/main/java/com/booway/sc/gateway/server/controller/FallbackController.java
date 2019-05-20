package com.booway.sc.gateway.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 熔断响应
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
@RestController
public class FallbackController
{
	@GetMapping("/fallback")
	public String fallback()
	{
		return "fallback";
	}
}
