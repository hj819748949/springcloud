package com.booway.sc.user.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * 配置
 * 
 * @author jsb-hujie
 * 
 *         2019年5月5日
 *
 */
@Configuration
public class FeignSupportConfig
{
	/**
	 * 设置编码解码器
	 * @return
	 */
	@Bean
	public Encoder feignFormEncoder()
	{
		return new SpringFormEncoder();
	}
}
