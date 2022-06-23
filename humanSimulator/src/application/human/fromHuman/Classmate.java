package application.human.fromHuman;

import application.human.Human;
import java.util.Random;

/**
 * Klasa reprezentujaca ucznia
 */

public class Classmate extends Human {

    Random random = new Random();
    public boolean isFriend=false;
    public boolean isBully=false;

    /**
     * metoda Ktora zmienia pole klasy isFriend w zaleznosci od losowo generowanego inta
     */
    public void beFriend(){
        if(random.nextInt(100)+1>90) {
            isFriend=true;
        }
    }

    /**
     *  metoda ktora w zaleznosci od losowo generowanego inta oraz wieku zmienia pole klasy isBully;
     */
    public void beBully(){
        if((random.nextInt(100)+1>95) && !isFriend && age<18) {
            isBully=true;
        }
    }
}
