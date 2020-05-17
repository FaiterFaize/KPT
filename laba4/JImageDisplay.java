import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
    private BufferedImage image;

    public JImageDisplay (int x, int y) {
        image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        Dimension dimension = new Dimension(x, y);
        //отражение изображения
        super.setPreferredSize(dimension);
    }

    //метод для вывода на экран изображения
    public void painComponents (Graphics g) {
        g.drawImage(image,0,0,image.getWidth(),image.getHeight(),null);
    }

    //метод для заполнения в черный цвет
    public void clearImage () {
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                image.setRGB(i, j, 0);
            }
        }
    }

    //метод для установки цвета в каждый пиксель
    public void drawPixel (int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }
}
