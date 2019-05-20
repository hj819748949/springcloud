package com.booway.sc.common.utils;

/**
 * 类工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
public class ClassUtil
{
	private ClassUtil() { }
	
	/**
	 * 获取ClassLoader
	 * @return
	 */
	public static ClassLoader getClassLoader()
	{
		return getClassLoader(ClassUtil.class);
	}
	/**
	 * 获取ClassLoader
	 * @param clazz
	 * @return
	 */
	public static ClassLoader getClassLoader(Class<?> clazz)
	{
		return null == clazz ? ClassUtil.class.getClassLoader() : clazz.getClassLoader();
	}
	/**
	 * 获取实例
	 * @param clazz
	 * @return
	 */
	public static <T> T getInstance(Class<T> clazz)
	{
		try 
		{
			return clazz.newInstance();
		} catch (Exception e)
		{
			// 这个地方就直接打印
			e.printStackTrace();
		}
		return null;
	}
}
