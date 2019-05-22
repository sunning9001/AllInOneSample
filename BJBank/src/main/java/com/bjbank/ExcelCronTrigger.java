package com.bjbank;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This Example will demonstrate all of the basics of scheduling capabilities of
 * Quartz using Cron Triggers.
 * 
 * @author Bill Kratzer
 */
public class ExcelCronTrigger {

	public static final Logger logger = LoggerFactory.getLogger(CronTrigger.class);
	private Scheduler sched ;
	
	
	public Scheduler getSched() {
		return sched;
	}

	public void setSched(Scheduler sched) {
		this.sched = sched;
	}

	public void run(String cronTime)  {


		try {
			cronTime ="0 15 10 * * ? *";
			logger.info("ExcelCronTrigger  config  cronTime:{}",cronTime);
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sched = sf.getScheduler();
			this.setSched(sched);
			
			JobDetail job = newJob(ExcelJob.class).withIdentity("job1", "group1").build();
			
			CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1")
					.withSchedule(cronSchedule(cronTime)).build();
			
			Date ft = sched.scheduleJob(job, trigger);
			
			logger.info(job.getKey() + " has been scheduled to run at: " + ft + " and repeat based on expression: "
					+ trigger.getCronExpression());
			
		} catch (Exception e) {
			logger.info("ExcelCronTrigger exception:{}",e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {

		ExcelCronTrigger example = new ExcelCronTrigger();
		example.run("0 15 10 * * ? *");
	}

}