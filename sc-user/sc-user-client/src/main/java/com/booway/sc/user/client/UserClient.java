package com.booway.sc.user.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.booway.sc.user.client.config.FeignSupportConfig;
import com.booway.sc.user.client.fallback.UserClientFallback;
import com.booway.sc.user.entity.dto.UserDto;

/**
 * 用户客户端
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@FeignClient(name = "service-user", path = "/service/user", 
	configuration = FeignSupportConfig.class, fallback = UserClientFallback.class)
public interface UserClient
{
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryById")
	List<UserDto> queryById(@RequestParam("id") Integer id);
	
	/**
	 * 上传文件
	 * @param file
	 * @return
	 */
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	String upload(@RequestPart(name = "file") MultipartFile file);
	
	/**
	 * 测试熔断器
	 * @param id
	 * @return
	 */
	@PostMapping("/testhystrix")
	String testhystrix(@RequestParam("id") Integer id);
}
