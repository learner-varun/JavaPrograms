package threadclass;

public class BaseRunner {
    public static void main(String args[]){
        ThreadRunner t1=new ThreadRunner();
t1.start();
while(t1.counter)
{
    System.out.print("*");
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
        ThreadRunnerTwo t2=new ThreadRunnerTwo();
        Thread t3 =new Thread(t2);
        t3.start();
        while(t2.counter)
        {
            System.out.print("*");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

