package day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void animalTest() {
        //Polymorphism - reference is Parent and object is child:
        Animal animal = new Dog();
        animal.move();
        animal.move(25);
        //Downcast to playable, so we are able to access Playable methods
        Playable playable = (Playable) animal;
        System.out.println("playable.getName() = " + playable.getName());
        Assertions.assertEquals("Thor", playable.getName());
        playable.playGame();

        ((Dog)animal).move(10);
        ((Playable)animal).playGame();
    }
}
