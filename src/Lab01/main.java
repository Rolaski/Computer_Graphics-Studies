package Lab01;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main
{
    public static void main(String args[]) throws IOException {
        BufferedImage img = null;
        File f = null;


        // wczytaj obraz
        try
        {
            f = new File("img/obraz.jpg");
            img = ImageIO.read(f);
            imgNegative2(img);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

        int width = img.getWidth();
        int height = img.getHeight();
        int p = img.getRGB(width / 2, height / 2);

        int a = (p >> 24) & 0xff;
        int r = (p >> 16) & 0xff;
        int g = (p >> 8) & 0xff;
        int b = p & 0xff;

        // Ustawiamy wartosci poszczegolnych kanalow na przykładowe liczby
        a = 255;
        r = 100;
        g = 150;
        b = 200;


        img.setRGB(width / 2, height / 2, p);

        // zapis obrazu
        try
        {
            f = new File("img/modified.jpg");
            ImageIO.write(img, "png", f);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }

    public static void allWhite(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int whiteRGB = (255 << 16) | (255 << 8) | 255;


        for(int i=0; i<width; i++)
        {
            for(int j=0; j<height; j++)
            {
                img.setRGB(i,j,whiteRGB);
            }
        }

    }

    public static void imgNegative(BufferedImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                int pixel = img.getRGB(i, j);

                // wartosci kanalow
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                // odwrocenie kanalow
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                // tworzenie nowych pixeli
                int negativePixel = (a << 24) | (r << 16) | (g << 8) | b;

                img.setRGB(i, j, negativePixel);
            }
        }
    }

    public static void imgNegative2(BufferedImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                int pixel = img.getRGB(i, j);

                Color color = new Color(pixel);

                int r = 255 - color.getRed();
                int g = 255 - color.getGreen();
                int b = 255 - color.getBlue();

                Color negativeColor = new Color(r, g, b);
                int negativePixel = negativeColor.getRGB();
                img.setRGB(i, j, negativePixel);
            }
        }
    }

}
