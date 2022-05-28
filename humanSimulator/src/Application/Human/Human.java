package Application.Human;

import java.util.Random;


public class Human {

    public Random random = new Random();

    String name;
    String surname;
    int age = 0;
    int gender = random.nextInt(2)+1;
    int charisma = random.nextInt(55)+21;
    int intelligence = random.nextInt(55)+21;
    int wisdom = random.nextInt(55)+21;
    int strength = random.nextInt(55)+21;
    int mentalHealth = 70;
    int earnings = 0;


}
