package com.company;

import com.company.BurningShip;
import com.company.FractalExplorer.ActionH.MouseH;
import com.company.FractalGenerator;
import com.company.JImageDisplay;
import com.company.Tricorn;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class FractalExplorer {
    private int displaySize;
    private JImageDisplay image;
    private FractalGenerator generator;
    private Rectangle2D.Double range;
    JComboBox<FractalGenerator> box;

    // Создание
    public FractalExplorer(int displaySize) {
        this.displaySize = displaySize;
        this.generator = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        generator.getInitialRange(this.range);
    }

    //События
    public class ActionH implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Reset")) {
                generator.getInitialRange(range);
                drawFractal();
            } else if (e.getActionCommand().equals("Save")) {
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Image", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                int a = chooser.showSaveDialog(image);
                if (a == JFileChooser.APPROVE_OPTION) {
                    try {
                        javax.imageio.ImageIO.write(image.getBufferedImage(), "png", chooser.getSelectedFile());
                    } catch (NullPointerException | IOException e1) {
                        javax.swing.JOptionPane.showMessageDialog(image, e1.getMessage(), "Cant save this image", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    generator = (FractalGenerator) box.getSelectedItem();
                    range = new Rectangle2D.Double(0, 0, 0, 0);
                    generator.getInitialRange(range);
                    drawFractal();
                }
            }
        }

        //События для кнопок мыши
        public class MouseH extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent event) {

                //Получение координаты х, соответствующую координате пикселя Х
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, event.getX());

                //Получение координаты y, соответствующую координате пикселя Y
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize, event.getY());

                generator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
                drawFractal();
            }
        }




        //Голова
        public void main(String[] args) {
            FractalExplorer frac = new FractalExplorer(800);
            frac.createAndShowGUI();
            frac.drawFractal();
        }
    }

    // Отрисовка
    private void drawFractal() {
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
    //Создание и редактирование для UI
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Fractal");
        image = new JImageDisplay(displaySize, displaySize);
        JButton resetB = new JButton("Reset");
        resetB.setActionCommand("Reset");
        JButton save = new JButton("Save");
        save.setActionCommand("Save");
        box = new JComboBox<FractalGenerator>();
        box.addItem(new Mandelbrot());
        box.addItem(new Tricorn());
        box.addItem(new BurningShip());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JLabel l1 = new JLabel("Fractal: ");


        //обработка событий
        ActionH action = new ActionH();
        ActionH.MouseH mouseH = new ActionH.MouseH();
        resetB.addActionListener(action);
        save.addActionListener(action);
        image.addMouseListener(mouseH);
        p1.add(l1, BorderLayout.CENTER);
        p1.add(box, BorderLayout.CENTER);
        p2.add(resetB, BorderLayout.CENTER);
        p2.add(save, BorderLayout.CENTER);

        box.addActionListener(action);

        //расположение на интерфейсе
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(image, BorderLayout.CENTER);
        frame.add(p1, BorderLayout.NORTH);
        frame.add(p2,BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Размещение содержимого окна
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
