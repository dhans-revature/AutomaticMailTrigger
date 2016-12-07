package schedular;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Java8Schedular {
  public static Runnable mailTrigger =
      () -> System.out.println("Trigger email based on SLA config from db");

  public static void main(String[] args) throws InterruptedException {
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    scheduledExecutorService.scheduleAtFixedRate(mailTrigger, 0, 5, TimeUnit.SECONDS);

    Thread.sleep(20L * 1000);
    scheduledExecutorService.shutdown();
  }
}
