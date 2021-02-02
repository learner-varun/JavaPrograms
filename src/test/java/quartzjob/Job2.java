package quartzjob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class Job2 implements Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job2 --->>> Hello geeks! Time is " + new Date());
    }
}