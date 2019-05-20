package com.booway.sc.config.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 
 * @author jsb-hujie
 * 
 * 2019年5月6日
 *
 */
@Configuration
@ConditionalOnClass(RefreshEndpoint.class)
@AutoConfigureAfter(RefreshAutoConfiguration.class)
@ConditionalOnProperty("spring.cloud.config.refreshInterval")
public class ConfigClientRefreshAutoConfiguration implements SchedulingConfigurer
{
	/** 取值 */
	@Value("${spring.cloud.config.refreshInterval}")
	private long refreshInterval;
	
	/** 刷新点 */
	@Autowired
	private RefreshEndpoint refreshEndpoint;
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar)
	{
		long interval = refreshInterval * 1000;
		taskRegistrar.addFixedDelayTask(new IntervalTask(new Runnable()
		{
			@Override
			public void run()
			{
				// 执行刷新
				refreshEndpoint.refresh();
			}
		}, interval));
	}
}
