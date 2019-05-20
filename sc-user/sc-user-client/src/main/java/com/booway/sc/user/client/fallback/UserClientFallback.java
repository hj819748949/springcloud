package com.booway.sc.user.client.fallback;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.booway.sc.user.client.UserClient;
import com.booway.sc.user.entity.dto.UserDto;

/**
 * 用户客户端容错
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Component
public class UserClientFallback implements UserClient
{
	@Override
	public List<UserDto> queryById(Integer id)
	{
		return null;
	}
	@Override
	public String upload(MultipartFile file)
	{
		return null;
	}
	@Override
	public String testhystrix(Integer id)
	{
		return "testhystrix";
	}
}
