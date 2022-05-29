package Application.Human.fromHuman;

import Application.Human.Human;
import java.util.Random;

public class Father extends Human {

    public int attentionToChildren = random.nextInt(100)+1;
    public int loveToChildren = random.nextInt(100)+1;


    public void influenceKid() {
        int potentialBonuses = (wisdom/15 + attentionToChildren/5 + loveToChildren/15) * random.nextInt(1000);
    }
}
