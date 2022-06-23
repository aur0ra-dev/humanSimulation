package application.human.fromHuman;

import application.human.Human;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa repreztuntojaca glownego bohatera
 */
public class MainCharacter extends Human {

    public boolean haveAPartner = false;
    public Human partner = new Human();
    public List<Classmate> listOfFriends = new ArrayList<>();
    public List<Classmate> listOfBullies = new ArrayList<>();
    public List<Human> listofChildren = new ArrayList<>();
    public int bonusesToEarnings = 0;
    public int healthEvent=1;
    public Father father = new Father();
    public Mother mother = new Mother();
    public String education = "none";


    /**
     * Metoda zliczajaca srednia wartosc pol klasy human w zaleznosci od losowo generowanych obiektow Classmate <br>
     * oraz zwiekszajaca pola obiektu klasy mainCharacter
     */

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

    /**
     * Metoda zmieniajaca pola obiektu klasy main character w zaleznosci od wartosci pola age
     * oraz pol obiektu klasy father i mather i ich  srednich wartosci
     */
    public void gatherFromParents () {

        if(age<17) {
            int avgCharisma = ((father.charisma + mother.charisma) / 2) / 75;
            int avgIntelligence = ((father.intelligence + mother.intelligence) / 2) / 75;
            int avgWisdom = mother.wisdom / 100;
            int avgStrength = father.strength / 100;

            charisma += avgCharisma;
            intelligence += avgIntelligence;
            wisdom += avgWisdom;
            strength += avgStrength;

            mentalHealth += random.nextInt((father.attentionToChildren / 15) + 1) - random.nextInt(6);
            mentalHealth += random.nextInt((mother.loveToChildren / 15) + 1) - random.nextInt(5);

        }
    }

    /**
     * metoda modyfikujaca pola obiektu klasa main character w zaleznosci od losowo generowanych zmiennych oraz wartosci
     * pola mentalHealth
     */
    public void Reflections () {

        mentalHealth += random.nextInt(6)-5;


        if(mentalHealth>100)
            mentalHealth = 100;
        else if (mentalHealth < 0) {
            mentalHealth = 0;
        }

        if(mentalHealth>70) {
            charisma += random.nextInt(5) + (charisma*3)/100;
            intelligence += random.nextInt(5) + (intelligence*3)/100;
            wisdom += random.nextInt(5) + (wisdom*3)/100;
            strength += random.nextInt(5) + (strength*3)/100;

        } else if (mentalHealth<70 && mentalHealth > 45) {
            charisma += random.nextInt(5) + (charisma*2)/100;
            intelligence += random.nextInt(5) + (intelligence*2)/100;
            wisdom += random.nextInt(5) + (wisdom*2)/100;
            strength += random.nextInt(5) + (strength*2)/100;
        } else if (mentalHealth<11) {

            charisma += random.nextInt(5);
            intelligence += random.nextInt(5);
            wisdom += random.nextInt(5);
            strength += random.nextInt(5);

            if(mentalHealth<1)
                mentalHealth=0;
            else
                healthEvent=random.nextInt(mentalHealth);
        } else {
            charisma += random.nextInt(5) + (charisma)/100;
            intelligence += random.nextInt(5) + (intelligence)/100;
            wisdom += random.nextInt(5) + (wisdom)/100;
            strength += random.nextInt(5) + (strength)/100;
        }


    }
    public void seekLove () {
        if(!haveAPartner && (charisma/10 + random.nextInt(70)>90)) {
            haveAPartner=true;
            if(gender==1) {
                partner.gender=2;
                partner.name = "Agnieszka";
                partner.surname = "Kowalska";
            } else {
                partner.gender=1;
                partner.name = "Andrzej";
                partner.surname = "Cukierek";

            }
        } else if(haveAPartner && (random.nextInt(100)>75)) {
            listofChildren.add(new Human());
            listofChildren.get(listofChildren.size()-1).name="temporary bachor name";
            listofChildren.get(listofChildren.size()-1).name=surname;
        }
        if(listofChildren.size()>0){
            for (Human listofChild : listofChildren) listofChild.age++;
        }
    }
    public void showStatistics () {

            System.out.println("This is summary of your person:");
            System.out.println("Name: " + name);
            System.out.println("surname: " + surname);
            System.out.println("age: " + age);
            if(gender==1)
                System.out.println("gender: male");
            else
                System.out.println("gender: female");

            System.out.println("education: " + education);
            System.out.println("number of children: " + listofChildren.size());
            System.out.println("monthly earnings in PLN: " + earnings);

    }


}
