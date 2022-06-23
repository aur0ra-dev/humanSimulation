package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import java.util.List;

/**
 * Klasa sluzaca do porownywania wartosci
 */
public class Comparisons {

    public float charismaDif;
    public float strengthDif;
    public float intelligenceDif;
    public float wisdomDif;

    DecimalFormat dec = new DecimalFormat("#0.00");

    /**
     *  Metoda odpowiadajaca za wyswietlanie, gdzie wartosci podane jako parametry  znajduja sie wzgledem sredniej <br>
     *  wyswiela je na ekranie oraz zapisuje je do pliku za pomoca metod  klasy BufferedWritter
     * @param strength wartosc integer reprezentujaca sile
     * @param intelligence wartosc integer reprezentujaca inteligencje
     * @param wisdom wartosc integer reprezentujaca wiedze
     * @param charisma wartosc integer reprezentujaca charyzme
     * @param age wartosc integer reprezentujaca wiek
     * @throws RuntimeException jesli wystapi blad z zapisem do pliku
     */
    public void showcase (float strength, float intelligence, float wisdom, float charisma, int age) {
        BufferedWriter writerShowcase;
        try {
            writerShowcase = new BufferedWriter(new FileWriter("statystyki.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            System.out.println("at age " + age + " your person was: ");
            writerShowcase.append("at age ").append(String.valueOf(age)).append(" your person was: ");
            writerShowcase.append('\n');

            if(strength>=0) {
                System.out.println(dec.format(strength) + "% stronger than average");
                writerShowcase.append(dec.format(strength)).append("% stronger than average");
                writerShowcase.append('\n');
            }else {
                strength=strength/(-1);
                System.out.println(dec.format(strength) + "% weaker than average");
                writerShowcase.append(dec.format(strength)).append("% weaker than average");
                writerShowcase.append('\n');
            }

            if(intelligence>=0) {
                System.out.println(dec.format(intelligence) + "% more intelligent than average");
                writerShowcase.append(dec.format(intelligence)).append("% more intelligent than average");
                writerShowcase.append('\n');
            }else {
                intelligence=intelligence/(-1);
                System.out.println(dec.format(intelligence) + "% less intelligent than average");
                writerShowcase.append(dec.format(intelligence)).append("% less intelligent than average");
                writerShowcase.append('\n');
            }

            if(charisma>=0) {
                System.out.println(dec.format(charisma) + "% more charismatic than average");
                writerShowcase.append(dec.format(charisma)).append("% more charismatic than average");
                writerShowcase.append('\n');
            }else {
                charisma=charisma/(-1);
                System.out.println(dec.format(charisma) + "% less charismatic than average");
                writerShowcase.append(dec.format(charisma)).append("% less charismatic than average");
                writerShowcase.append('\n');
            }

            if(wisdom>=0) {
                System.out.println(dec.format(wisdom) + "% more clever than average");
                writerShowcase.append(dec.format(wisdom)).append("% more clever than average");
                writerShowcase.append('\n');
            }else {
                wisdom=wisdom/(-1);
                System.out.println(dec.format(wisdom) + "% less clever than average");
                writerShowcase.append(dec.format(wisdom)).append("% less clever than average");
                writerShowcase.append('\n');
            }

            writerShowcase.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Metoda przy uzyciu petli dodaje wartosci pol obietku klasy comparators do zainicjalizowanych wyzej zmienny nastepnie liczy srednia
     * nastepnie przy uzyciu intrukcji warunkowej sprawadza na podstawie pol obietku klasy  MainCharaceter roznice pomiedzy wartosciami
     * i zapisuje je do zminenych
     * @param mainCharacter Przyjmuje obiekt klasy MainCharacter
     * @param listToCompare Przyjumje list obiektow ktore sa porownywane
     */
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

    /**
     * Metoda przy uzyciu metod klasy BufferedWritter zapisuje tekst oddzielajacy koeljne symulacja
     * @throws RuntimeException jesli wystapi blad z zapisem do pliku
     */
    public void fileSave(){
        BufferedWriter writerFileSave;
        try {
            writerFileSave = new BufferedWriter(new FileWriter("statystyki.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            writerFileSave.append("!!! NEW SIMULATION !!!\n");
            writerFileSave.close();

        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

}
