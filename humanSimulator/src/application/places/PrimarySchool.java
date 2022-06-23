package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Klasa reprezentujaca placowke edukacyjna - Szkole podstawowa
 */
public class PrimarySchool extends EducationPlaces {
    Random random = new Random();
    int numberOfTeachers = 3;
    public int numberOfClassmates = 20 + random.nextInt(6);
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();


    /**
     *  Modyfikuje pola obiektu klasa MainCharaceter w zaleznosci od pol klasy
     * @param mainCharacter przyjmuje obiekt klasy MainCharaceter
     * @return zwraca obiekt klasy MainCharaceter
     */
    public MainCharacter sendKidToContest(MainCharacter mainCharacter){

        mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*100;

        return mainCharacter;
    }

    /**
     * Inicjalizuje wartosci pola klasy w zaleznosci pol obiektu klasy MainCharacter i polacznym z nich obiektow klasy Mother i Father
     * @param mainCharacter przyjmuje jako parametr obiekt klasy MainCharacter
     */


}
