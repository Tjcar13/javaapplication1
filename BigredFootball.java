/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Thomas
 */
public class BigredFootball {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    BufferedImage inputImage = ImageIO.read(new File("C:/Users/Thomas/Desktop/bigredFootball.jpg"));
    
    BufferedImage outputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    
    for(int y = 0; y < inputImage.getHeight(); y++)
    {
        for (int x = 0;x < inputImage.getWidth(); x++)
        {
            int pixel = inputImage.getRGB(x, y);
            int shiftedPixel = pixel;
            
            if(x ==0 && y == 0)
                    System.out.println(pixel);
                
                int blue = pixel & 255; //0xff
                
                shiftedPixel = shiftedPixel >> 8; //shiftedPixel >>=8
                int green = shiftedPixel & 255;
                
                 shiftedPixel = shiftedPixel >> 8; //shiftedPixel >>=8
                int red = shiftedPixel & 255; 
                
                
                int iRed = 255 - red;
                int iGreen = 255 - green;
                int iBlue = 255 - blue;
                
                int finalPixel = (iRed << 16) + (iGreen << 8) + (iBlue);
                
                if(x == 0 && y == 0)
                    System.out.println(red + "-" + green + "-" + blue);
                
                
                
                
                outputImage.setRGB(x, y, finalPixel);
        }
    }
     ImageIO.write(outputImage, "PNG", new File("c:/Users/Thomas/Desktop/newPhoto.png") );
    }
    
}
