package activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car(){
        tyres=4;
        doors=4;
    }

    public void displayCharacteristics(){
        System.out.println("Color of Car: "+color+'\n'
        +"Transmission of Car: "+transmission+'\n'+
        "Make of Car: "+make+'\n'+
        "No. of Tyres in Car: "+tyres+'\n'+
                "No. of Door in Cars: "+doors);
    }

    public void accelarate(){
        System.out.println("Car is moving forward.");
    }

    public void brake(){
        System.out.println("Car has stopped.");
    }
}
