package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasa reprezentujaca placowke edukacyjna
 */

public class College extends EducationPlaces {

    Random random = new Random();
    int numberOfTeachers = 15;
    public int numberOfClassmates = 60 + random.nextInt(140);
    public List <Classmate> listOfClassmates = new ArrayList<>();
    public List<Teacher> listOfTeachers = new ArrayList<>();


    /**
     * Metoda modyfikuje pole obiektu klasy Main Character w zaleznosci od pol obiektu klasy i losowo generowanej wartosci
     * @param mainCharacter
     * @return zwraca obiekt klasy Main characeter
     */

    public MainCharacter apprenticeships(MainCharacter mainCharacter){
        mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*200;

        return mainCharacter;
    }

    /**
     * Metoda przyjmujaca jako argument obiekt klasy MainCharacter zwracaja wartosc 1 lub w zaleznosci pol obiektu klasy Main Character <br>
     * oraz pol obiektu College
     * Wyswietlajaca komunikat dla uzytkownika
     * @param mainCharacter
     * @return zwaraca int
     */
    public int session(MainCharacter mainCharacter){
        if(((mainCharacter.intelligence+mainCharacter.wisdom)/15+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/3 + random.nextInt(101))<50) {
            System.out.println("Oh no! Your person dropped out of college!");
            return 0;
        }
        else
            return 1;

    }

    /**
     * Metoda przyjmujaca obiekt klasy MainCharaceter jako parametr oraz modyfikujaca pola klasy MainCharacter w zaleznosci od pol <br>
     * tego samego obiektu oraz obiektu klasy College <br>
     * Wyswietlajaca komuniakt dla uzytkownika
     * @param mainCharacter
     * @return zwraca obiekt Klasy MainCharacter
     */
    public MainCharacter thesisDefense (MainCharacter mainCharacter){
        if (((mainCharacter.intelligence+mainCharacter.wisdom)/20+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/4 + random.nextInt(101))>50) {
            mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*350;
            mainCharacter.education = "higher";
            System.out.println("good, your character finished college");
        }
        return mainCharacter;
    }

    /**
     * Metoda modyfikujaca pola klasy College w zaleznosci od pol obiektu klasy mainCharaceter
     * przyjmuje jako parametr obeikt klasy MainCharaceter
     * tworzy i daodaje obiekty klasy Teacher do pola klasy
     * @param mainCharacter
     */


}
