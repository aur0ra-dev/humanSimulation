package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * klasa reprezentujaca placowke edukacyjna - Przedszkole
 */

public class Kindergarten extends EducationPlaces {

    Random random = new Random();
    int numberOfTeachers = 1;
    public int numberOfClassmates = 15 + random.nextInt(11);
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();

    /**
     * modyfikuje pole obiektu klasy MainCharacter w zalezynosci od pola klasy i losowo generowanych wartosci
     * @param mainCharacter przyjmuje obiekt klasy MainCharaceter
     * @return zwraca Obiekt klasy MainCharaceter
     */
    public MainCharacter careOverKid(MainCharacter mainCharacter){
        mainCharacter.mentalHealth+=((levelOfEducation + wealthOfPlace + prestigeOfPlace) - random.nextInt(30) + random.nextInt(15));
        return mainCharacter;
    }
    /**
     * Inicjalizuje wartosci pola klasy w zaleznosci pol obiektu klasy MainCharacter i polacznym z nich obiektow klasy Mother i Father
     * @param mainCharacter przyjmuje jako parametr obiekt klasy MainCharacter
     */

}
