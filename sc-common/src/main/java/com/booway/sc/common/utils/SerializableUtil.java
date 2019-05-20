package com.booway.sc.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
@SuppressWarnings("all")
public class SerializableUtil
{
	private SerializableUtil() { }

	/**
	 * 对象序列化成字节数组
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static byte[] doSerializable(Object obj) throws Exception
	{
		ByteArrayOutputStream byteOut = null;
		ObjectOutput out = null;
		byte[] result = null;
		try
		{
			byteOut = new ByteArrayOutputStream();
			out = new ObjectOutputStream(byteOut);
			out.writeObject(obj);
			out.flush();
			byteOut.flush();
			result = byteOut.toByteArray();
		} finally
		{
			StreamUtil.closeObjectOutput(out);
			StreamUtil.closeStream(byteOut);
		}
		return result;
	}
	/**
	 * 字节数组反序列化成对象
	 * @param objArr
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T deSerializable(byte[] objArr, Class<T> clazz) throws Exception
	{
		ByteArrayInputStream byteIn = null;
		ObjectInput in = null;
		Object result = null;
		try
		{
			byteIn = new ByteArrayInputStream(objArr);
			in = new ObjectInputStream(byteIn);
			result = in.readObject();
		} finally
		{
			StreamUtil.closeObjectInput(in);
			StreamUtil.closeStream(byteIn);
		}
		return (T) result;
	}
	public static <T> T deSerializable(File objFile, Class<T> clazz) throws Exception
	{
		return deSerializable(new FileInputStream(objFile), clazz);
	}
	public static <T> T deSerializable(InputStream objStream, Class<T> clazz) throws Exception
	{
		return deSerializable(StreamUtil.getStreamBytes(objStream), clazz);
	}
	public static <T> T deSerializable(String objPath, Class<T> clazz) throws Exception
	{
		return deSerializable(new File(objPath), clazz);
	}
}
