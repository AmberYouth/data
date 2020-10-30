package singleresponsibility;

public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
    }
}

class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle+"在路上走");
    }
}
