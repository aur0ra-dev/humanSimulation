package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import java.util.List;

public class Comparisons {

    public float charismaDif;
    public float strengthDif;
    public float intelligenceDif;
    public float wisdomDif;

    DecimalFormat dec = new DecimalFormat("#0.00");


    public void showcase (float strength, float intelligence, float wisdom, float charisma, int age) {
        BufferedWriter writerShowcase = null;
        try {
            writerShowcase = new BufferedWriter(new FileWriter("statystyki.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            System.out.println("at age " + age + " your person was: ");
            writerShowcase.append("at age " + age + " your person was: ");
            writerShowcase.append('\n');

            if(strength>=0) {
                System.out.println(dec.format(strength) + "% stronger than average");
                writerShowcase.append(dec.format(strength) + "% stronger than average");
                writerShowcase.append('\n');
            }else {
                strength=strength/(-1);
                System.out.println(dec.format(strength) + "% weaker than average");
                writerShowcase.append(dec.format(strength) + "% weaker than average");
                writerShowcase.append('\n');
            }

            if(intelligence>=0) {
                System.out.println(dec.format(intelligence) + "% more intelligent than average");
                writerShowcase.append(dec.format(intelligence) + "% more intelligent than average");
                writerShowcase.append('\n');
            }else {
                intelligence=intelligence/(-1);
                System.out.println(dec.format(intelligence) + "% less intelligent than average");
                writerShowcase.append(dec.format(intelligence) + "% less intelligent than average");
                writerShowcase.append('\n');
            }

            if(charisma>=0) {
                System.out.println(dec.format(charisma) + "% more charismatic than average");
                writerShowcase.append(dec.format(charisma) + "% more charismatic than average");
                writerShowcase.append('\n');
            }else {
                charisma=charisma/(-1);
                System.out.println(dec.format(charisma) + "% less charismatic than average");
                writerShowcase.append(dec.format(charisma) + "% less charismatic than average");
                writerShowcase.append('\n');
            }

            if(wisdom>=0) {
                System.out.println(dec.format(wisdom) + "% more clever than average");
                writerShowcase.append(dec.format(wisdom) + "% more clever than average");
                writerShowcase.append('\n');
            }else {
                wisdom=wisdom/(-1);
                System.out.println(dec.format(wisdom) + "% less clever than average");
                writerShowcase.append(dec.format(wisdom) + "% less clever than average");
                writerShowcase.append('\n');
            }

            writerShowcase.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
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
