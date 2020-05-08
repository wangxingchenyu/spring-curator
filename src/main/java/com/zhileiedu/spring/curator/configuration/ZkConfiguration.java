package com.zhileiedu.spring.curator.configuration;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 王志雷
 * @Date: 2020/5/8 14:21
 */
@Configuration
public class ZkConfiguration {

	@Autowired
	WrapperZk wrapperZk;

	@Bean(initMethod = "start")
	public CuratorFramework curatorFramework() {
		RetryNTimes retryNTimes = new RetryNTimes(3, 3000);
		return CuratorFrameworkFactory.newClient(wrapperZk.getConnectString(),
				wrapperZk.getSessionTimeoutMs(),
				wrapperZk.getConnectionTimeoutMs(),
				new RetryNTimes(wrapperZk.getRetryCount(), wrapperZk.getElapsedTimeMs())
		);
	}





}
