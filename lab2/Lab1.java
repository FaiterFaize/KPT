import java.util.Scanner;


public class Lab1 {

    public static double computeArea(Point3d f, Point3d s, Point3d t) {
        if (f.e(s) || f.e(t) || s.e(t)) {
            return 0.0;
        }
        double a = Math.sqrt(Math.pow(f.getX() - s.getX(), 2) + Math.pow(f.getY() - s.getY(), 2));
        double b = Math.sqrt(Math.pow(f.getX() - t.getX(), 2) + Math.pow(f.getY() - t.getY(), 2));
        double c = Math.sqrt(Math.pow(s.getX() - t.getX(), 2) + Math.pow(s.getY() - t.getY(), 2));
        //формула полупериметра треугольника
        double p = (a + b + c) / 2;
        //формула Герона
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("\nПлощадь треугольника: " + S);
        return S;
    }
    //ввод координат
    public static void main(String[] args){
        Scanner v = new Scanner(System.in);
        System.out.println("Введите кординаты точки А: ");
        Point3d A = new Point3d(v.nextDouble(), v.nextDouble(), v.nextDouble());
        System.out.println("Введите кординаты точки B: ");
        Point3d B = new Point3d(v.nextDouble(), v.nextDouble(), v.nextDouble());
        System.out.println("Введите кординаты точки C: ");
        Point3d C = new Point3d(v.nextDouble(), v.nextDouble(), v.nextDouble());
        computeArea(A, B, C);
    }
}
