package activities;

public class MountainBike extends Bicycle{
    int seatHeight;
    MountainBike(int gears, int currentSpeed,int seatHeight) {
        super(gears, currentSpeed);
        this.seatHeight=seatHeight;
    }

    public void setHeight(int seatNewHeight) {
        seatHeight = seatNewHeight;
    }

    @Override
    public String bicycleDesc(){
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed + "\nSeat Height of bicycle is " + seatHeight);
    }
}
