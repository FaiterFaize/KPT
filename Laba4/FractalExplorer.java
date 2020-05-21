import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;



public class FractalExplorer {
    private int displaySize;
    private JImageDisplay image;
    private FractalGenerator generator;
    private Rectangle2D.Double range;

    //
    public FractalExplorer (int displaySize) {
        this.displaySize = displaySize;
        this.generator = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        generator.getInitialRange(this.range);
    }

    //События
    public class ActionH implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                generator.getInitialRange(range);
                drawFractal();
        }
    }

    //События для кнопок мыши
    public class MouseH extends MouseAdapter {
        public void mouseClicked (MouseEvent event) {

            //Получение координаты х, соответствующую координате пикселя Х
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, event.getX());

            //Получение координаты y, соответствующую координате пикселя Y
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, event.getY());

            generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    //Создание и редактирование для UI
    public void createAndShowGUI () {
            JFrame frame = new JFrame("Исследовать фрактал");
            image = new JImageDisplay(displaySize, displaySize);
            JButton resetB = new JButton("Вернуть");

            //обработка событий
            ActionH action = new ActionH();
            MouseH mouseH = new MouseH();
            resetB.addActionListener(action);
            image.addMouseListener(mouseH);

            //расположение на интерфейсе
            frame.setLayout(new java.awt.BorderLayout());
            frame.add(image, BorderLayout.CENTER);
            frame.add(resetB, BorderLayout.SOUTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Размещение содержимого окна
            frame.pack();
            frame.setVisible(true);
            frame.setResizable(false);
    }

    //Отрисовка
    public void drawFractal () {
        for (int x = 0; x < displaySize; x++) {
            for (int y = 0; y < displaySize; y++) {
                int numIt = generator.numIterations(FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, x), FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, y));
                if (numIt == -1) {
                    image.drawPixel(x, y, 0);
                } else {
                    float hue = 0.7f + (float) numIt / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    image.drawPixel(x, y, rgbColor);
                }
            }
        }
        image.repaint();
    }

    //Голова
    public static void main(String[] args) {
        FractalExplorer frac = new FractalExplorer(400);
        frac.createAndShowGUI();
        frac.drawFractal();
    }
}
