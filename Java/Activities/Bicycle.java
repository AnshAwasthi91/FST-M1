package activities;

public class Bicycle implements BicycleParts, BicycleOperations{

    public int gears;
    public int currentSpeed;

    Bicycle(int gears,int currentSpeed){
        this.gears=gears;
        this.currentSpeed=currentSpeed;
    }
    @Override
    public void applyBreak(int decrement) {
        System.out.println("Brakes applied.. Bicycle Speed is reduced by :: "+decrement+" Km/hr");
    }

    @Override
    public void speedUp(int increment) {
        System.out.println("Acceleration applied.. Bicycle Speed is increased by :: "+increment+" Km/hr");
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}
