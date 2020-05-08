package com.zhileiedu.spring.curator.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: 王志雷
 * @Date: 2020/5/8 14:20
 */
@Data
@Component
@ConfigurationProperties(prefix = "curator")
public class WrapperZk {

	private int retryCount;

	private int elapsedTimeMs;

	private String connectString;

	private int sessionTimeoutMs;

	private int connectionTimeoutMs;

}
