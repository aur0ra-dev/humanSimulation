package application.human.fromHuman;

import application.human.Human;
import java.util.ArrayList;
import java.util.List;

public class MainCharacter extends Human {

    public int numberOfChildren = 0;
    public boolean haveAPartner = false;
    public List<Classmate> listOfFriends = new ArrayList<>();
    public List<Classmate> listOfBullies = new ArrayList<>();
    public int numberOfFriends = listOfFriends.size();
    public int numberOfBullies= listOfBullies.size();
    public int health = random.nextInt(80)+21;
    public int bonusesToEarnings = 0;
    public int healthEvent;

    public Father father = new Father();
    public Mother mother = new Mother();


    public void gatherFromFriends () {

        int avgCharisma = 0;
        int avgIntelligence = 0;
        int avgWisdom = 0;
        int avgStrength = 0;

        if(numberOfFriends>0) {
            for(int i = 0;i < numberOfFriends;i++) {
                avgCharisma += listOfFriends.get(i).charisma;
                avgIntelligence += listOfFriends.get(i).intelligence;
                avgWisdom += listOfFriends.get(i).wisdom;
                avgStrength += listOfFriends.get(i).strength;
            }
            avgCharisma = (avgCharisma/numberOfFriends)/20;
            avgIntelligence = (avgIntelligence/numberOfFriends)/20;
            avgWisdom = (avgWisdom/numberOfFriends)/20;
            avgStrength = (avgStrength/numberOfFriends)/20;

            charisma += avgCharisma;
            intelligence += avgIntelligence;
            wisdom += avgWisdom;
            strength += avgStrength;
        }

        mentalHealth += random.nextInt(5*(numberOfFriends+1)) - random.nextInt(4*(numberOfBullies+1));





    }
    public void gatherFromParents () {
        int avgCharisma = ((father.charisma+mother.charisma)/2)/20;
        int avgIntelligence = ((father.intelligence+mother.intelligence)/2)/20;
        int avgWisdom = mother.wisdom/20;
        int avgStrength = father.strength/20;

        charisma += avgCharisma;
        intelligence += avgIntelligence;
        wisdom += avgWisdom;
        strength += avgStrength;

        mentalHealth += random.nextInt((father.attentionToChildren/10)+1) - random.nextInt(10);
        mentalHealth += random.nextInt((mother.loveToChildren/10)+1) - random.nextInt(10);
    }
    public void Reflections () {



        if(mentalHealth>100)
            mentalHealth = 100;
        else if (mentalHealth < 0) {
            mentalHealth = 0;
        }

        if(mentalHealth>70) {
            charisma += charisma/ (random.nextInt(6)+1)+20;
            intelligence += intelligence/(random.nextInt(6)+1)+20;
            wisdom += wisdom/(random.nextInt(6)+1)+20;
            strength += strength/(random.nextInt(6)+1)+20;

        } else if (mentalHealth<=70 && mentalHealth > 45) {
            charisma += charisma/ (random.nextInt(11)+1)+20;
            intelligence += intelligence/(random.nextInt(11)+1)+20;
            wisdom += wisdom/(random.nextInt(11)+1)+20;
            strength += strength/(random.nextInt(11)+1)+20;
        } else if (mentalHealth<11) {

            if(mentalHealth<1)
                mentalHealth=1;
            healthEvent=random.nextInt(mentalHealth);
            if (healthEvent == 0) {
                //suicide
            }

        }


    }


}
