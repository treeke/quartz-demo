package quartz.demo;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QuartzService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuartzService.class);
    
	@Value("{autoStartup}")
	private boolean autoStartup;

	@Autowired
	// @Qualifier("Scheduler")
	private Scheduler scheduler;

	public void initialize() throws InterruptedException {
		LOGGER.debug("是否启动QuartzService: {}", autoStartup);

		if (autoStartup) {
			try {
				scheduler.startDelayed(5);
				System.out.println(Thread.currentThread().getName());
				//Thread.sleep(6*1000);
				System.out.println(scheduler.isStarted());
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
	}

}
