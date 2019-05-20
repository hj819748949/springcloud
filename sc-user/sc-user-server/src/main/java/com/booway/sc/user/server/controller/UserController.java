package com.booway.sc.user.server.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.booway.sc.common.controller.Abstractcontroller;
import com.booway.sc.common.utils.CommonUtil;
import com.booway.sc.user.entity.dto.UserDto;
import com.booway.sc.user.server.entity.User;
import com.booway.sc.user.server.service.UserService;

/**
 * 用户Controller
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Controller
@RequestMapping("/service/user")
public class UserController extends Abstractcontroller
{
	/** 用户业务 */
	@Autowired
	private UserService userService;
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryById")
	@ResponseBody
	public List<UserDto> queryById(@RequestParam("id") Integer id)
	{
		
		String xx = getRequest().getHeader("xxxxx");
		System.out.println(xx);
		
		List<User> users = userService.findByAge(id);
		List<UserDto> rs = null;
		if (CommonUtil.isNotEmpty(users))
		{
			rs = new ArrayList<UserDto>();
			for (User user : users)
			{
				UserDto ud = new UserDto();
				BeanUtils.copyProperties(user, ud);
				rs.add(ud);
			}
		}
		return rs;
	}
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseBody
	public String upload(@RequestPart(name = "file") MultipartFile file)
	{
		return file == null ? "error" : file.getOriginalFilename();
	}
	/**
	 * 测试熔断器
	 * @param id
	 * @return
	 */
	@RequestMapping("/testhystrix")
	@ResponseBody
	public String testhystrix(@RequestParam("id") Integer id)
	{
		if (id == null || id != 0)
		{
			return "success";
		} else 
		{
			throw new RuntimeException("error.");
		}
	}
}
