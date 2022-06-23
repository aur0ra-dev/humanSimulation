package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

/**
 * Klasa reprezentujaca placowke edukacyjna - Szkole srednia
 */
public class HighSchool extends EducationPlaces {

    Random random = new Random();
    int numberOfTeachers = 10;
    public int numberOfClassmates = 20 + random.nextInt(11);
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();


    /**
     * Metoda przyjmujaca jako argumenty dwa inty
     * modyfikuje ze zminne basic score oraz extended score w zaleznosci od pol klasy oraz podanych paramertrow i losowo generowanych wartosci
     * @param intelligence zmienna typu integer
     * @param wisdom zmienna typu integer
     * @return zwraca wartosc liczbowa modyfikowanych wczesniej zmiennych
     */
    public int schoolLeavingExam(int intelligence, int wisdom){
        int basic_score = intelligence/10 + wisdom/80 + (levelOfEducation+wealthOfPlace+prestigeOfPlace)/5 + random.nextInt(55);
        if(basic_score > 100)
            basic_score = 100;

        int extended_score = intelligence/15 + wisdom/100 +(levelOfEducation+wealthOfPlace+prestigeOfPlace)/8 + random.nextInt(50);
        if(extended_score > 100)
            extended_score = 100;

        return (extended_score*7+basic_score*3)/10;
    }

    /**
     * Inicjalizuje wartosci pola klasy w zaleznosci pol obiektu klasy MainCharacter i polacznym z nich obiektow klasy Mother i Father
     * @param mainCharacter przyjmuje jako parametr obiekt klasy MainCharacter
     */



}
