package application.human.fromHuman;

import application.human.Human;
import java.util.Random;

public class Mother extends Human {

    Random random = new Random();

    public int charisma = random.nextInt(250)+150;
    public int intelligence = random.nextInt(250)+150;
    public int wisdom = random.nextInt(1500)+1000;
    public int earnings =  (random.nextInt(15)+random.nextInt(15))*2000;
    public int loveToChildren = 50 + random.nextInt(51) - random.nextInt(51);

    public MainCharacter showLoveToKid(MainCharacter mainCharacter) {
        mainCharacter.mentalHealth += random.nextInt(1+loveToChildren/20);
        return mainCharacter;
    }



}
