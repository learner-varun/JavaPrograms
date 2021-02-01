package barcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class QRCode {
        static String text = "This is test QR code ";
        public static void main(String args[])
        {
            write();
            read();
        }
        public static void read() {
            Result result = null;
            try {
                InputStream barCodeInputStream = new FileInputStream("src/Data/QR.png");
                BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);
                LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Reader reader = new MultiFormatReader();
                result = reader.decode(bitmap);
                System.out.println("Text in QA code is : " + result.getText().trim());
            } catch (Exception e) {
            }
        }
        public static void write()
        {
            try {
                int width = 400;
                int height = 300;
                String imageFormat = "png";
                BitMatrix bitMatrix = new QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
                MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, new FileOutputStream(new File("src/Data/QR.png")));
            }catch (Exception e){}
        }
    }


