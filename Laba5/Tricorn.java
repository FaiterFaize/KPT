package com.company;

import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator {

    //Константа с максимальным количеством итераций
    public static final int MAX_ITERATION = 2000;
    @Override
    //определение наиболее интерстной области плоскости (Диапозон)
    public void getInitialRange (Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.height = 4;
        range.width = 4;
    }
    @Override
    //Подсчет итераций
    public int numIterations (double x, double y) {
        double Re = x; //действительная часть
        double Im = y; // мнимая часть
        int it = 0; // число итераций
        while (it < MAX_ITERATION) {
            it++;
            double Re1 = x * x - y * y + Re;
            double Im1 = 2 * x * y + Im;
            x = Re1;
            y = Im1;
            if ((x * x + y * y) > 5) {
                break;
            }
            //Если дошел до максимума
            if (it == MAX_ITERATION) {
                return -1;
            }
        }
        return it;
    }

    public String toString() {
        return "Tricorn";
    }
}
