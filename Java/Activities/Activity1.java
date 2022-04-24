package activities;

public class Activity1 {

    public static void main(String[] args) {
        //Creating the Car class object
        Car car = new Car();

        //Initializing the Car attribues
        car.make=2014;
        car.color="Black";
        car.transmission="Manual";

        //Calling the car methods
        car.displayCharacteristics();
        car.accelarate();
        car.brake();
    }
}
