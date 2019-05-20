package com.booway.sc.common.utils;

import java.io.File;

/**
 * 路径工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
public class PathUtil
{
	private PathUtil() { }
	
	/**
	 * 处理路径
	 * @param realPath
	 * @return
	 */
	public static String eraseSeparator(String realPath)
    {
    	if (CommonUtil.isEmpty(realPath))
    	{
    		return realPath;
    	}
    	return eraseSeparator(realPath, File.separator);
    }
	/**
	 * 转换到指定的路径分割符
	 * @param realPath   路径
	 * @param separator  分割符
	 * @return
	 */
	public static String eraseSeparator(String realPath, String separator)
	{
		if (CommonUtil.isEmpty(realPath))
    	{
    		return realPath;
    	}
		StringBuffer buf = new StringBuffer();
    	for (int i = 0; i < realPath.length(); i++)
    	{
    		String ch = realPath.charAt(i) + "";
    		if (ch.equals("/") || ch.equals("\\"))
    		{
    			ch = separator;
    		}
    		buf.append(ch);
    	}
    	return buf.toString();
	}
}
