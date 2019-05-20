package com.booway.sc.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * 网络工具类
 * 
 * @author jsb-hujie
 *
 * 2019年3月23日
 */
@SuppressWarnings("all")
public class NetUtil
{
	private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("127(\\.\\d{1,3}){3}$");
	
	private static volatile InetAddress LOCAL_ADDRESS = null;
	
	public static final String LOCALHOST = "127.0.0.1";
	
	private NetUtil() { }
	
	/**
	 * 根据域名获取ip
	 * @param hostName
	 * @return
	 */
	public static String getIpByHost(String hostName) 
	{
        try 
        {
            return InetAddress.getByName(hostName).getHostAddress();
        } catch (UnknownHostException e) 
        {
            return hostName;
        }
    }
	/**
	 * 判断是不是本地ip
	 * @param host
	 * @return
	 */
	public static boolean isLocalHost(String host) 
	{
        return host != null
                && (LOCAL_IP_PATTERN.matcher(host).matches()
                || host.equalsIgnoreCase("localhost"));
    }
}
