package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class College {

    Random random = new Random();

    public int numberOfClassmates = 60 + random.nextInt(140);
    public List <Classmate> listOfClassmates = new ArrayList<>();
    public List<Teacher> listOfTeachers = new ArrayList<>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;

    public MainCharacter apprenticeships(MainCharacter mainCharacter){
        mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*200;

        return mainCharacter;
    }
    public int session(MainCharacter mainCharacter){
        if(((mainCharacter.intelligence+mainCharacter.wisdom)/15+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/3 + random.nextInt(101))<50) {
            return 0;
        }
        else
            return 1;

    }
    public MainCharacter thesisDefense (MainCharacter mainCharacter){
        if (((mainCharacter.intelligence+mainCharacter.wisdom)/20+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/4 + random.nextInt(101))>50) {
            mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*350;
        }
        return mainCharacter;
    }

    public void initializePlace (MainCharacter mainCharacter) {
        prestigeOfPlace=(mainCharacter.father.intelligence+mainCharacter.mother.intelligence)/130+mainCharacter.intelligence/60;
        levelOfEducation=(mainCharacter.father.wisdom+mainCharacter.mother.wisdom)/350+mainCharacter.wisdom/150;
        wealthOfPlace=(mainCharacter.father.earnings+mainCharacter.mother.earnings)/4000;
        for(int v = 0; v < 15 ;v++){
            listOfTeachers.add(new Teacher());
        }
    }

}
