package com.booway.sc.gateway.server.test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * 时间测试
 * @author jsb-hujie
 * 
 * 2019年5月8日
 *
 */
public class DateTest
{
	@Test
	public void test()
	{
		// plusMinutes 增加 3分钟
		String str = ZonedDateTime.now().plusMinutes(2L).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
		System.out.println(str);
	}
}
