package application.places;

import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.List;

abstract public class EducationPlaces {

    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;







    public void initializePlace (MainCharacter mainCharacter, int n, List<Teacher> listOfTeachers) {
        prestigeOfPlace=(mainCharacter.father.intelligence+mainCharacter.mother.intelligence)/90+mainCharacter.intelligence/60;
        levelOfEducation=(mainCharacter.father.wisdom+mainCharacter.mother.wisdom)/250+mainCharacter.wisdom/100;
        wealthOfPlace=(mainCharacter.father.earnings+mainCharacter.mother.earnings)/4000;
        for(int g = 0; g < 3; g++){
            listOfTeachers.add(new Teacher());
        }
    }
}
