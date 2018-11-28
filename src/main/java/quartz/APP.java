package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

 	
import quartz.demo.DefaultJob;
import quartz.demo.QuartzService;


@SpringBootApplication
//@Order(value=1)
public class APP implements ApplicationRunner{
	@Autowired
	private QuartzService service;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(APP.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*Class cls = Class.forName("quartz.demo.DefaultJob");
		cls.newInstance();
		// 构建job信息
		JobDetail job = JobBuilder.newJob(cls).withIdentity("job1","gourp1")
				.usingJobData("key1", 1).build();
		// 触发时间点
*/		//CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ? ");
		/*Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "gourp1").startNow()
				.withSchedule(cronScheduleBuilder).build();
		// 交由Scheduler安排触发
		java.util.Date date = scheduler.scheduleJob(job, trigger);*/
		service.initialize();
	}

}
