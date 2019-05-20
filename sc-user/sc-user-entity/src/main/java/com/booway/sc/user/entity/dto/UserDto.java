package com.booway.sc.user.entity.dto;

import lombok.Getter;
import lombok.Setter;
import com.booway.sc.common.entity.dto.AbstractDto;

/**
 * 用户Dto
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Getter
@Setter
public class UserDto extends AbstractDto
{
	private static final long serialVersionUID = 4500110587880671307L;
	
	private int age;
	
}
