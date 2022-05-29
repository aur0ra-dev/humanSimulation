package Application.Human.fromHuman;

import Application.Human.Human;

public class Mother extends Human {

    protected int attentionToChildren = random.nextInt(100)+1;
    protected int loveToChildren = random.nextInt(100)+1;

    public void showLoveToKid() {
        int healthCare = (intelligence/15 + attentionToChildren/15 + loveToChildren/5) * random.nextInt(10);
    }


}
