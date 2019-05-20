package com.booway.sc.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * id工具类 
 * @author jsb-hujie
 *
 * 2019年4月20日
 */
public class IdUtil
{
	private IdUtil() { }
	
	/**
	 * id列表转换成list
	 * @param idStr
	 * @return
	 * @throws Exception 
	 */
	public static List<Long> splitIdToList(String idStr) throws Exception
	{
		if (null == idStr)
		{
			return null;
		}
		return splitIdToList(idStr, ",");
	}
	/**
	 * id列表转换成list
	 * @param idStr      id列表
	 * @param splitReg   分隔符
	 * @return
	 * @throws Exception 
	 */
	public static List<Long> splitIdToList(String idStr, String splitReg) throws Exception
	{
		if (null == idStr || splitReg == null)
		{
			return null;
		}
		String[] idArr = idStr.split(splitReg);
		List<Long> rs = new ArrayList<Long>();
		for (String id : idArr)
		{
			try 
			{
				rs.add(Long.parseLong(id));
			} catch (Exception e)
			{
				throw new Exception("id格式不正确.");
			}
		}
		return rs;
	}
}
