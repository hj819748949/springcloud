package com.booway.sc.consul.role.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色Controller
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@RestController
@RequestMapping("/service/role")
public class RoleController
{
	/**
	 * 添加
	 * @param x
	 * @param y
	 * @return
	 */
	@GetMapping("/add")
	public int add(@RequestParam("x") int x, @RequestParam("y") int y)
	{
		return x + y;
	}
}
