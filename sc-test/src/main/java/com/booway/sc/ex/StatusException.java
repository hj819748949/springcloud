package com.booway.sc.ex;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
@Getter
@Setter
public class StatusException extends Exception
{
	private static final long serialVersionUID = 3503303694401573791L;

	/** 自己定义status */
	private int status;
	
	public StatusException(int status, String message)
	{
		super(message);
		this.status = status;
	}
	public StatusException()
	{
		super();
	}
	public StatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public StatusException(String message, Throwable cause)
	{
		super(message, cause);
	}
	public StatusException(String message)
	{
		super(message);
	}
	public StatusException(Throwable cause)
	{
		super(cause);
	}
}
