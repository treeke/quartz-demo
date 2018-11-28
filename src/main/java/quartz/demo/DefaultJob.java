package quartz.demo;

import java.time.LocalDateTime;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinux.unet.common.support.KeySupport;


public class DefaultJob implements IJob {
	private final static Logger logger = LoggerFactory.getLogger(DefaultJob.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -8248095838135146648L;


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(Thread.currentThread().getName()+"............................."+getTaskId(context));
	}


	/**
	 * 从context获取任务参数
	 * 
	 * @param context
	 * @return
	 */
	private long getTaskId(JobExecutionContext context) {
		long taskId = 0;
		// 获取 JobDataMap , 并从中取出任务参数
		JobDataMap data = context.getJobDetail().getJobDataMap();
		try {
			taskId = data.getLong(KeySupport.KEY_DEF_TASK_ID);
			return taskId;
		} catch (Exception e) {
			logger.error("从JobDataMap获取TaskId发生异常,JobDataMap-{}", data);
		}
		return taskId;
	}
	@Override
	public String doTest(String str) {
		return "DefaultJob test OK. " + LocalDateTime.now();
	}

	
}
