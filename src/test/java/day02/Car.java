package day02;

public class Car {
    private String model;
    //Encapsulation:
    private double price;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new RuntimeException("Price is negative");
        }
        this.price = price;
    }

    public void drive() {
        System.out.println("Driving " + model);
    }
}
