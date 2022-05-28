package Application.Human;

import java.util.Random;


public class Human {

    public Random random = new Random();

    protected String name;
    protected String surname;
    protected int age = 0;
    protected int gender = random.nextInt(2)+1;
    protected int charisma = random.nextInt(55)+21;
    protected int intelligence = random.nextInt(55)+21;
    protected int wisdom = random.nextInt(55)+21;
    protected int strength = random.nextInt(55)+21;
    protected int mentalHealth = 70;
    protected int earnings = 0;


}
