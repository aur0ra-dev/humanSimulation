package Application.Human.fromHuman;
import Application.Human.Human;
import java.util.Random;

public class Classmate extends Human {

    Random random = new Random();
    public boolean isFriend=false;
    public boolean isBully=false;



    public void beFriend(){
        if(random.nextInt(100)+1>90) {
            isFriend=true;
        }
    }
    public void beBully(){
        if((random.nextInt(100)+1>95) && isFriend==false) {
            isBully=true;
        }
    }
}
