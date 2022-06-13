package application.human.fromHuman;

import application.human.Human;
import java.util.Random;

public class Father extends Human {

    Random random = new Random();

    public String name = "temporary_name";
    public String surname = "temporary_surname";
    public int age = random.nextInt(25)+18;
    public int gender=1;
    public int charisma = random.nextInt(150)+40;
    public int intelligence = random.nextInt(150)+40;
    public int wisdom = random.nextInt(150)+40;
    public int strength = random.nextInt(150)+40;
    public int mentalHealth = random.nextInt(80)+20;
    public int earnings =  (random.nextInt(15)+random.nextInt(15))*2000;



    public int attentionToChildren = random.nextInt(100)+1;
    public int loveToChildren = random.nextInt(100)+1;


    public void influenceKid() {
        int potentialBonuses = (wisdom/15 + attentionToChildren/5 + loveToChildren/15) * random.nextInt(1000);
    }
}
