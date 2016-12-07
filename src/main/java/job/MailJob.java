package job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MailJob implements Job {
  public void execute(JobExecutionContext context) throws JobExecutionException {
    System.out.println("Trigger email based on SLA config from db");
  }

}
