package day02;

public abstract class Animal {

    //protected abstract void speak();

    public Animal() {
        System.out.println("Animal object");
    }

    //Final method cannot be overriden
    public final void move(){
        System.out.println("Animal is moving");
    }

    public void move(int distance){
        System.out.println("Animal is moving distance = " + distance);
    }
}
//Class can extend one class and can implement multiple interfaces
class Dog extends Animal implements Playable, Petable{
    @Override
    public void move(int speed) {
        System.out.println("Dog is running at " + speed +" mph");
    }

    @Override
    public String getName() {
        return "Thor";
    }
} //IsFriendly

class Lion extends Animal implements Wild { }

class Duck extends Animal implements Flyable, Swimable{ }

class Dolphin extends Animal implements Playable, Swimable, Petable{
    @Override
    public String getName() {
        return "Bessie";
    }
} // IsFriendly

class Parrot extends Animal implements Flyable{ }

// Interface:

interface Playable {
    public static final String feature = "playful";
    public static void play() {
        System.out.println("playing");
    }
    public abstract String getName();
    public default void playGame() {
        System.out.println("playing some general game");
    }
}

interface Swimable {}

interface Wild {}

interface Flyable {}

interface Petable {}

interface IsFriendly extends Playable, Petable {}







