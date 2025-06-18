package car;

public class Car {
    String model;
    String brand;
    int year;
    double fuel;
    Car(String brand,String model,int year,double fuel){
        this.brand=brand;
        this.model=model;
        this.year=year;
        this.fuel=fuel;
    }
    void drive(double distance){
        double fuelConsumed=distance*0.05;
        if(fuel>=fuelConsumed){
            fuel -= fuelConsumed;
        System.out.println("Driving " + distance + " km...");
        System.out.println("fuel remaining: " + fuel + " liters.");
    } else {
        System.out.println("Not enough fuel to drive " + distance + " km.");
    }
    }
    void refuel(double liters) {
        fuel += liters;
        System.out.println("Refuel " + liters + " liters.");
        System.out.println("Total fuel: " + fuel + " liters.");
    }
    void display(){
        System.out.println("Brand="+brand);
        System.out.println("Model="+model);
        System.out.println("Year="+year);
        System.out.println("Fuel="+fuel + "liters");
    }
    public static void main(String[] args) {
     Car c = new Car("Toyota","Fortuner",2024,50);
     c.display();
     c.drive(50);
     c.refuel(20);
    }

}
