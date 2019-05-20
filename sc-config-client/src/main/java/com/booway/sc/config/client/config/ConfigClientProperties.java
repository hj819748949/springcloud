package com.booway.sc.config.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 测试变更配置文件
 * @author jsb-hujie
 * 
 * 2019年5月6日
 *
 */
@Getter
@Setter
@Component
@RefreshScope
public class ConfigClientProperties
{
	/** 从github上获取的变量 */
	@Value("${xx}")
	private String xx;
	
	
}
