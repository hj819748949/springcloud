package com.booway.sc.ex;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月7日
 *
 */
public class ExTest
{
	public void test()
	{
		try 
		{
			throw new StatusException();
		} catch (StatusException e)
		{
			
			int status = e.getStatus();
			
			// 构建异常数据
		} catch (Exception e)
		{
			//
		}
	}
}
