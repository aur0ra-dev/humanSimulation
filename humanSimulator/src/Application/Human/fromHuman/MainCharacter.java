package Application.Human.fromHuman;

import Application.Human.Human;
import java.util.ArrayList;
import java.util.List;

public class MainCharacter extends Human {

    protected int numberOfChildren = 0;
    protected boolean haveAPartner = false;
    protected List<Classmate> listOfFriends = new ArrayList<>();
    protected int numberOfFriends = listOfFriends.size();
    protected int health = random.nextInt(80)+21;
    protected int bonusesToEarnings = 0;


    protected void gatherFromFriends () {

        int avgCharisma = 0;
        int avgIntelligence = 0;
        int avgWisdom = 0;
        int avgStrength = 0;

        if(numberOfFriends>0) {
            for(int i = 0;i <= numberOfFriends;i++) {
                avgCharisma += listOfFriends.get(i).charisma;
                avgIntelligence += listOfFriends.get(i).intelligence;
                avgWisdom += listOfFriends.get(i).wisdom;
                avgStrength += listOfFriends.get(i).strength;
            }
            avgCharisma = avgCharisma/numberOfFriends;
            avgIntelligence = avgIntelligence/numberOfFriends;
            avgWisdom = avgWisdom/numberOfFriends;
            avgStrength = avgStrength/numberOfFriends;
        }



    }
    protected void gatherFromParents () {

    }
    protected void Reflections () {

    }


}
