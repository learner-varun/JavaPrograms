package threadclass;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class ThreadRunner extends Thread {
 boolean counter=true;
        public void run(){
            File file = new File("src/Data/FP.pdf");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Downloaded Starting");
            try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://www.hq.nasa.gov/alsj/a17/A17_FlightPlan.pdf").openStream());
                 FileOutputStream fileOS = new FileOutputStream("src/Data/FP.pdf")) {
                byte data[] = new byte[1024];
                int byteContent;
                while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                    fileOS.write(data, 0, byteContent);
                }
            } catch (Exception e) {

            }
            counter =false;
            System.out.println("\nDownloaded successfully");
        }

}
