package com.booway.sc.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

/**
 * 流工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
public class StreamUtil
{
	private StreamUtil() { }
	
	/**
	 * 关闭流
	 * @param streams
	 */
	public static void closeStream(AutoCloseable ...streams)
	{
		if (null != streams && streams.length != 0)
		{
			for (AutoCloseable stream : streams)
			{
				if (stream != null)
				{
					try
					{
						stream.close();
					} catch (Exception e)
					{
						
					}
				}
			}
		}
	}
	/**
	 * 1.6关闭流
	 * @param streams
	 */
	/*public static void closeStream(Closeable ...streams)
	{
		if (null != streams && streams.length != 0)
		{
			for (Closeable stream : streams)
			{
				if (stream != null)
				{
					try
					{
						stream.close();
					} catch (Exception e)
					{
						
					}
				}
			}
		}
	}*/
	/**
	 * 关闭流
	 * @param di
	 */
	public static void closeObjectInput(ObjectInput oi)
	{
		if (null == oi)
		{
			return;
		}
		try 
		{
			oi.close();
		} catch (Exception e)
		{
			
		}
	}
	/**
	 * 关闭流
	 * @param di
	 */
	public static void closeObjectOutput(ObjectOutput oo)
	{
		if (null == oo)
		{
			return;
		}
		try 
		{
			oo.close();
		} catch (Exception e)
		{
			
		}
	}
	/**
	 * 拷贝流
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void copyStream(InputStream in, OutputStream out) throws IOException
	{
		int len = 0;
		byte[] buf = new byte[1024 * 10];
		while ((len = in.read(buf)) > 0)
		{
			out.write(buf, 0, len);
		}
		// 关闭流
		closeStream(in, out);
	}
	/**
	 * 获取流的字节数组
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static byte[] getStreamBytes(InputStream in) throws IOException
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int len = 0;
		byte[] buf = new byte[1024 * 10];
		while ((len = in.read(buf)) > 0)
		{
			out.write(buf, 0, len);
		}
		closeStream(in);
		return out.toByteArray();
	}
	/**
	 * 流转换成字符换
	 * @param in
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String getStreamTxt(InputStream in, String charset) throws IOException
	{
		byte[] buf = getStreamBytes(in);
		return new String(buf, charset);
	}
	/**
	 * 流转换成字符换
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String getStreamTxt(InputStream in) throws IOException
	{
		return getStreamTxt(in, "utf-8");
	}
}
