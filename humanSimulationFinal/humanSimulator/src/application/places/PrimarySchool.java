package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimarySchool {
    Random random = new Random();
    public int numberOfClassmates = 20 + random.nextInt(6);
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;

    public MainCharacter sendKidToContest(MainCharacter mainCharacter){

        mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*100;

        return mainCharacter;
    }

    public void initializePlace (MainCharacter mainCharacter) {
        prestigeOfPlace=(mainCharacter.father.intelligence+mainCharacter.mother.intelligence)/90+mainCharacter.intelligence/60;
        levelOfEducation=(mainCharacter.father.wisdom+mainCharacter.mother.wisdom)/250+mainCharacter.wisdom/100;
        wealthOfPlace=(mainCharacter.father.earnings+mainCharacter.mother.earnings)/4000;
        for(int g = 0; g < 3; g++){
            listOfTeachers.add(new Teacher());
        }
    }

}
