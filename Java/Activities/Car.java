package activities;

public class Car {
    String color;
    int make;
    String transmission;
    int tyres;
    int doors;

    Car() {
        tyres = 4;
        doors = 4;
    }
    public void displayCharacterstics(){
        System.out.println("Color of the car" +color);
        System.out.println("Make of the car" +make);
        System.out.println("Transmission of the car" +transmission);
        System.out.println("Number of the doors on the car" +doors);
        System.out.println("Number of the tyres on the car" +tyres);
    }

    public void accelerate() {
        System.out.println("Car is moving forward");
    }

    public void brake() {
        System.out.println("Car has stopped");
    }


    }

