package ASCIIPicture.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import ASCIIPicture.common.Common;

public class ScaleImageUtil {

    public static BufferedImage resize(String originalImagePath, double compressPercent){
        BufferedImage img = null;
        BufferedImage compressImg = null;
        int width,height;
        try {
        	img = ImageIO.read(new File(originalImagePath));
        	width = (int)(img.getWidth() * compressPercent);
        	height = (int)(img.getHeight() * compressPercent);
        	compressImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );         
        	compressImg.getGraphics().drawImage(img, 0, 0, width, height, null);  
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressImg;
    }
    
    public static void saveImage(String scaledImagepath, BufferedImage img){
        try {
            FileOutputStream output = new FileOutputStream(new File(scaledImagepath)); 
            ImageIO.write(img, "jpg", output);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getPostfix(String inputFilePath) {
		return inputFilePath.substring(inputFilePath.lastIndexOf(Common.FULL_STOP) + 1);
	}
}
