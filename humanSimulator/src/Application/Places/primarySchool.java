package Application.Places;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.MainCharacter;
import Application.Human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class primarySchool {
    Random random = new Random();
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;
    public MainCharacter sendKidToContest(MainCharacter mainCharacter){

        mainCharacter.bonusesToEarnings+=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*100;

        return mainCharacter;
    }
}
