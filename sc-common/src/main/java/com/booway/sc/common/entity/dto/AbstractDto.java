package com.booway.sc.common.entity.dto;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

/**
 * 抽象dto
 * @author jsb-hujie
 * 
 * 2019年5月5日
 *
 */
@Getter
@Setter
public abstract class AbstractDto implements Serializable
{
	private static final long serialVersionUID = -1328556146588770826L;
	
	protected Long id;
	
}
