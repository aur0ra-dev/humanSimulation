package application.places;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Kindergarten {

    Random random = new Random();
    public int numberOfClassmates = 15 + random.nextInt(11);
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;

    public MainCharacter careOverKid(MainCharacter mainCharacter){
        mainCharacter.mentalHealth+=((levelOfEducation + wealthOfPlace + prestigeOfPlace) - random.nextInt(30) + random.nextInt(15));
        return mainCharacter;
    }
    public void initializePlace (MainCharacter mainCharacter) {
        prestigeOfPlace=(mainCharacter.father.intelligence+mainCharacter.mother.intelligence)/80;
        levelOfEducation=(mainCharacter.father.wisdom+mainCharacter.mother.wisdom)/200;
        wealthOfPlace=(mainCharacter.father.earnings+mainCharacter.mother.earnings)/4000;
        listOfTeachers.add(new Teacher());
    }

}
