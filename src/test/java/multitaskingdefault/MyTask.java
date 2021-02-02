package multitaskingdefault;

import java.util.TimerTask;

class MyTask extends TimerTask {

    public MyTask(){
        System.out.println("I am clled");
    }

    @Override
    public void run() {
        System.out.println("Hi see you after 10 seconds");

    }

}