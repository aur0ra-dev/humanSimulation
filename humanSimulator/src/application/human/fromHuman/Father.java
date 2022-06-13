package application.human.fromHuman;

import application.human.Human;
import java.util.Random;

public class Father extends Human {

    Random random = new Random();

    public int charisma = random.nextInt(150)+40;
    public int intelligence = random.nextInt(150)+40;
    public int wisdom = random.nextInt(150)+40;
    public int strength = random.nextInt(150)+40;
    public int earnings =  (random.nextInt(15)+random.nextInt(15))*2000;



    public int attentionToChildren = 50 + random.nextInt(51) - random.nextInt(51);


    public MainCharacter influenceKid(MainCharacter mainCharacter) {
        mainCharacter.bonusesToEarnings += (wisdom/15 + attentionToChildren/5 * random.nextInt(1000));
        return mainCharacter;
    }
}
