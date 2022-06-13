package application.human.fromHuman;

import application.human.Human;
import java.util.Random;

public class Mother extends Human {

    Random random = new Random();

    public String name = "temporary_name";
    public String surname = "temporary_surname";
    public int age = random.nextInt(20)+18;
    public int gender=1;
    public int charisma = random.nextInt(150)+40;
    public int intelligence = random.nextInt(150)+40;
    public int wisdom = random.nextInt(150)+40;
    public int strength = random.nextInt(150)+40;
    public int mentalHealth = random.nextInt(80)+20;
    public int earnings =  (random.nextInt(15)+random.nextInt(15))*2000;


    protected int attentionToChildren = random.nextInt(100)+1;
    protected int loveToChildren = random.nextInt(100)+1;

    public void showLoveToKid() {
        int healthCare = (intelligence/15 + attentionToChildren/15 + loveToChildren/5) * random.nextInt(10);
    }


}
