package schedular;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import job.MailJob;

public class QuartzSchedular {
  public static void main(String[] args) throws SchedulerException, InterruptedException {
    Scheduler scheduler = new StdSchedulerFactory().getScheduler();

    JobKey jobKey = new JobKey("emailJob", "group1");
    TriggerKey triggerKey = new TriggerKey("5SecTrigger", "group1");
    
    if (!scheduler.checkExists(jobKey)) {
      JobDetail job = JobBuilder.newJob(MailJob.class).withIdentity(jobKey).build();
      Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
          .withSchedule(
              SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
          .build();
      scheduler.start();
      scheduler.scheduleJob(job, trigger);
    }
    
    Thread.sleep(20L * 1000);
    scheduler.shutdown();

  }
}
