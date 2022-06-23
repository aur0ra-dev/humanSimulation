package application.human.fromHuman;

import application.human.Human;

/**
 * klasa reprezuntujaca osobe - nauczyciela

 */

public class Teacher extends Human {

    public int abilityToTeach = random.nextInt(90)+11;
    public int yearsOfExperience = 0;

    /**
     *  metoda ktora w zaleznosci od wartosci pola obiektu Teacher
     *
     * @return zwraca sume pol klasy teacher zmodyfikowana o losowo generowana zmienna
     */
    public int shareWisdom() {

        return (abilityToTeach/10 + yearsOfExperience) + random.nextInt(20);
    }
}
