package application.human.fromHuman;

import application.human.Human;
import java.util.Random;

public class Father extends Human {

    Random random = new Random();

    public int charisma = random.nextInt(250)+150;
    public int intelligence = random.nextInt(250)+150;
    public int wisdom = random.nextInt(1500)+1000;
    public int strength = random.nextInt(250)+150;
    public int earnings =  (random.nextInt(15)+random.nextInt(15))*2000;



    public int attentionToChildren = 50 + random.nextInt(51) - random.nextInt(51);


    public MainCharacter influenceKid(MainCharacter mainCharacter) {
        mainCharacter.bonusesToEarnings += (wisdom/15 + attentionToChildren/5 * random.nextInt(1000));
        return mainCharacter;
    }
}
