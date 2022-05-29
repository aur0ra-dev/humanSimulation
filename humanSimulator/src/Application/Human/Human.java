package Application.Human;

import java.util.Random;


public class Human {

    public Random random = new Random();

    public String name;
    public String surname;
    public int age = 0;
    public int gender = random.nextInt(2)+1;
    public int charisma = random.nextInt(55)+21;
    public int intelligence = random.nextInt(55)+21;
    public int wisdom = random.nextInt(55)+21;
    public int strength = random.nextInt(55)+21;
    public int mentalHealth = 70;
    public int earnings = 0;


}
