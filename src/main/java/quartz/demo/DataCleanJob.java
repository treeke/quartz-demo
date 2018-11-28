package quartz.demo;

import java.time.LocalDateTime;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataCleanJob implements IJob{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5083102602115611519L;
	private final static Logger logger = LoggerFactory.getLogger(DefaultJob.class);
	

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		logger.debug("---------清除定时------------");
	}

	@Override
	public String doTest(String str) {
		return "DataCleanJob test OK. " + LocalDateTime.now();
	}

}
