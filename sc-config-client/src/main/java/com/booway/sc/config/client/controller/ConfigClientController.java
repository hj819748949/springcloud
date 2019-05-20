package com.booway.sc.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.booway.sc.config.client.config.ConfigClientProperties;

/**
 * 配置客户端Controller
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Controller
@RefreshScope
@RequestMapping("/config/configclient")
public class ConfigClientController
{
	/** 测试 */
	@Autowired
	private ConfigClientProperties ccp;
	
	/**
	 * 获取变量
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		return ccp.getXx();
	}
}
