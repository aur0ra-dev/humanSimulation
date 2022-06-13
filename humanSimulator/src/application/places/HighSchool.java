package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class HighSchool {

    Random random = new Random();
    public int numberOfClassmates = 20 + random.nextInt(11);
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;

    public int schoolLeavingExam(int intelligence, int wisdom){
        int basic_score = intelligence/10 + wisdom/80 + (levelOfEducation+wealthOfPlace+prestigeOfPlace)/5 + random.nextInt(101);
        if(basic_score > 100)
            basic_score = 100;

        int extended_score = intelligence/15 + wisdom/100 +(levelOfEducation+wealthOfPlace+prestigeOfPlace)/8 + random.nextInt(101);
        if(extended_score > 100)
            extended_score = 100;

        return (extended_score*7+basic_score*3)/10;
    }

    public void initializePlace (MainCharacter mainCharacter) {
        prestigeOfPlace=(mainCharacter.father.intelligence+mainCharacter.mother.intelligence)/110+mainCharacter.intelligence/60;
        levelOfEducation=(mainCharacter.father.wisdom+mainCharacter.mother.wisdom)/300+mainCharacter.wisdom/130;
        wealthOfPlace=(mainCharacter.father.earnings+mainCharacter.mother.earnings)/4000;
        for(int v = 0; v < 10 ;v++){
            listOfTeachers.add(new Teacher());
        }
    }


}
