package com.booway.sc.common.utils;

/**
 * xpath工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
public class XPathUtil
{
	private XPathUtil() { }
	
	/**
	 * 获取父节点xpath
	 * @param xpath
	 * @return
	 */
	public static String getParentXPath(String xpath)
	{
		if (CommonUtil.isEmpty(xpath))
		{
			return null;
		}
		int index = -1;
		if ((index = xpath.lastIndexOf("/")) == -1)
		{
			return null;
		}
		return xpath.substring(0, index);
	}
}
