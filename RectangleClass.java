package rectangle;

public class RectangleClass {
    double length;
    double width;
    RectangleClass(double length,double width){
        this.length=length;
        this.width=width;
    }
    void calculateArea(){
        double area=length*width;
        System.out.println("Area:" +area);
    }
    void calculatePerimeter(){
        double perimeter=2*(length+width);
        System.out.println("Perimeter: "+perimeter);
    }
    void  displayDimensions(){
        System.out.println("Length: " + length + ", Width: " + width);
    }
    public static void main(String[]args){
        RectangleClass r1 = new RectangleClass(10.5,4.5);
        r1.displayDimensions();
        r1.calculateArea();
        r1.calculatePerimeter();

    }
}
