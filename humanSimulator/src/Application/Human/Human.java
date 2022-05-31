package Application.Human;

import java.util.Random;


public class Human {

    public Random random = new Random();

    public String name;
    public String surname;
    public int age;
    public int gender;
    public int charisma;
    public int intelligence;
    public int wisdom;
    public int strength;
    public int mentalHealth;
    public int earnings;

    public void showFutures(Human humanArg){
        System.out.println("Name: " + humanArg.name);
        System.out.println("surname: " + humanArg.surname);
        System.out.println("age: " + humanArg.age);
        System.out.println("gender: " + humanArg.gender);
        System.out.println("charisma: " + humanArg.charisma);
        System.out.println("strenght: " + humanArg.strength);
        System.out.println("intelligence: " + humanArg.intelligence);
        System.out.println("wisdom: " + humanArg.wisdom);
        System.out.println("mentalHealt: " + humanArg.mentalHealth);
        System.out.println("earning: " + humanArg.earnings);
    }


}
