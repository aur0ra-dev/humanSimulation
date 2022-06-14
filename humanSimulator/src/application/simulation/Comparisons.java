package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import java.text.DecimalFormat;

import java.util.List;

public class Comparisons {

    public float charismaDif;
    public float strengthDif;
    public float intelligenceDif;
    public float wisdomDif;

    DecimalFormat dec = new DecimalFormat("#0.00");


    public void showcase (float strength, float intelligence, float wisdom, float charisma, int age) {

        System.out.println("at age " + age + " your person was: ");

        if(strength>=0)
            System.out.println(dec.format(strength) + "% stronger than average");
        else {
            strength=strength/(-1);
            System.out.println(dec.format(strength) + "% weaker than average");
        }

        if(intelligence>=0)
            System.out.println(dec.format(intelligence) + "% more intelligent than average");
        else {
            intelligence=intelligence/(-1);
            System.out.println(dec.format(intelligence) + "% less intelligent than average");
        }

        if(charisma>=0)
            System.out.println(dec.format(charisma) + "% more charismatic than average");
        else {
            charisma=charisma/(-1);
            System.out.println(dec.format(charisma) + "% less charismatic than average");
        }

        if(wisdom>=0)
            System.out.println(dec.format(wisdom) + "% more clever than average");
        else {
            wisdom=wisdom/(-1);
            System.out.println(dec.format(wisdom) + "% less clever than average");
        }

    }

    public void compare (MainCharacter mainCharacter, List<Classmate> listToCompare) {


        float avgCharisma=0;
        float avgIntelligence=0;
        float avgWisdom=0;
        float avgStrength=0;

        for (Classmate comparators : listToCompare) {
            avgCharisma += comparators.charisma;
            avgIntelligence += comparators.intelligence;
            avgWisdom += comparators.wisdom;
            avgStrength += comparators.strength;
        }
        avgCharisma = avgCharisma/(listToCompare.size()+1);
        avgIntelligence = avgIntelligence/(listToCompare.size()+1);
        avgWisdom = avgWisdom/(listToCompare.size()+1);
        avgStrength = avgStrength/(listToCompare.size()+1);

        if (mainCharacter.charisma>avgCharisma)
            charismaDif = ((mainCharacter.charisma/avgCharisma)-1)*100;
        else
            charismaDif = ((avgCharisma/mainCharacter.charisma)-1)*(-100);

        if (mainCharacter.intelligence>avgIntelligence)
            intelligenceDif = ((mainCharacter.intelligence/avgIntelligence)-1)*100;
        else
            intelligenceDif = ((avgIntelligence/mainCharacter.intelligence)-1)*(-100);

        if (mainCharacter.wisdom>avgWisdom)
            wisdomDif = ((mainCharacter.wisdom/avgWisdom)-1)*100;
        else
            wisdomDif = ((avgWisdom/mainCharacter.wisdom)-1)*(-100);

        if (mainCharacter.strength>avgStrength)
            strengthDif = ((mainCharacter.strength/avgStrength)-1)*100;
        else
            strengthDif = ((avgStrength/mainCharacter.strength)-1)*(-100);

    }

}
