package com.booway.sc.consul.role.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 角色客户端
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@FeignClient(name = "service-role", path = "/service/role")
public interface RoleClient
{
	/**
	 * 执行累加
	 * @param x
	 * @param y
	 * @return
	 */
	@RequestMapping("/add")
	int add(@RequestParam("x") int x, @RequestParam("y") int y);
}
