package quartz.demo;

import java.io.Serializable;

import org.quartz.Job;

/**
 * 实现序列化接口、防止重启应用出现quartz Couldn't retrieve job because a required class was not
 * found 的问题
 */
public interface IJob extends Job, Serializable {

	/**
	 * 由于Job实现类都是被调度器反射调用的，为了验证反射的目标是否可用， 此方法可简单测试实现类能否实例化及正确调用
	 * 
	 * @return
	 */
	public String doTest(String str);

}
