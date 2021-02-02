package schedulejobstimer;

import java.util.TimerTask;

class MyTask extends TimerTask {
int i=0;
    public MyTask(){
        System.out.println("Constructor");
    }

    @Override
    public void run() {
        System.out.println("Hi see you after 10 seconds"+i);
        i=i+1;
    }


}