public class Point3d {
    private double x;
    private double y;
    private double z;

    public Point3d(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //изначально
    public Point3d(){
        x = y = z = 0.0;
    }
    //получение кординат
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    //присваивание
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    //сравнение значений двух обьектов
    public boolean e(Point3d other){
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }
    //вычисление дистанции
    public double distanceTo(Point3d other){
        return (Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2)));
    }
}
