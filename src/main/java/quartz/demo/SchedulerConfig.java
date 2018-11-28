package quartz.demo;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * quartz配置
 * 
 * @author Administrator
 *
 */
@Configuration
@Order(1)
public class SchedulerConfig {

	@Autowired
	private AutowireJobFactory autowireJobFactory;

	
	@Bean("UNETScheduler")
	public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();
		factory.setOverwriteExistingJobs(true);
		factory.setQuartzProperties(quartzProperties());
		// 自定义Job Factory，用于Spring注入
		factory.setJobFactory(autowireJobFactory);
		// 不自动启动，�?要启动定时器的项目应额外配置
		factory.setAutoStartup(false);
		// factory.setStartupDelay(20);
		return factory;
	}
	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

}