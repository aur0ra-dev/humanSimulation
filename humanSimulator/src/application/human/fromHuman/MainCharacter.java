package application.human.fromHuman;

import application.human.Human;
import java.util.ArrayList;
import java.util.List;

public class MainCharacter extends Human {

    public int numberOfChildren = 0;
    public boolean haveAPartner = false;
    public List<Classmate> listOfFriends = new ArrayList<>();
    public List<Classmate> listOfBullies = new ArrayList<>();
    public int bonusesToEarnings = 0;
    public int healthEvent=1;
    public Father father = new Father();
    public Mother mother = new Mother();
    public String education = "none";


    public void gatherFromFriends () {

        int avgCharisma = 0;
        int avgIntelligence = 0;
        int avgWisdom = 0;
        int avgStrength = 0;

        if(listOfFriends.size()>0) {
            for (Classmate listOfFriend : listOfFriends) {
                avgCharisma += listOfFriend.charisma;
                avgIntelligence += listOfFriend.intelligence;
                avgWisdom += listOfFriend.wisdom;
                avgStrength += listOfFriend.strength;
            }
            avgCharisma = (avgCharisma/listOfFriends.size())/20;
            avgIntelligence = (avgIntelligence/listOfFriends.size())/20;
            avgWisdom = (avgWisdom/listOfFriends.size())/20;
            avgStrength = (avgStrength/listOfFriends.size())/20;

            charisma += avgCharisma;
            intelligence += avgIntelligence;
            wisdom += avgWisdom;
            strength += avgStrength;
        }

        if(age<19 && age>2)
            mentalHealth += random.nextInt(3 * (listOfFriends.size() + 1)) - random.nextInt(5 * (listOfBullies.size() + 1));
    }
    public void gatherFromParents () {

        if(age<17) {
            int avgCharisma = ((father.charisma + mother.charisma) / 2) / 20;
            int avgIntelligence = ((father.intelligence + mother.intelligence) / 2) / 20;
            int avgWisdom = mother.wisdom / 20;
            int avgStrength = father.strength / 20;

            charisma += avgCharisma;
            intelligence += avgIntelligence;
            wisdom += avgWisdom;
            strength += avgStrength;

            mentalHealth += random.nextInt((father.attentionToChildren / 15) + 1) - random.nextInt(3);
            mentalHealth += random.nextInt((mother.loveToChildren / 15) + 1) - random.nextInt(3);
        }
    }
    public void Reflections () {

        mentalHealth += random.nextInt(6)-5;


        if(mentalHealth>100)
            mentalHealth = 100;
        else if (mentalHealth < 0) {
            mentalHealth = 0;
        }

        if(mentalHealth>70) {
            charisma += random.nextInt(11)+1;
            intelligence += random.nextInt(11)+1;
            wisdom += random.nextInt(11)+1;
            strength += random.nextInt(11)+1;

        } else if (mentalHealth<=70 && mentalHealth > 45) {
            charisma += random.nextInt(6)+1;
            intelligence += random.nextInt(6)+1;
            wisdom += random.nextInt(6)+1;
            strength += random.nextInt(6)+1;
        } else if (mentalHealth<11) {

            if(mentalHealth<1)
                mentalHealth=0;
            else
                healthEvent=random.nextInt(mentalHealth);
        }


    }


}
