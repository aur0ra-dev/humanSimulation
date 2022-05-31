package Application.Places;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class highSchool {

    Random random = new Random();
    public List<Classmate> listOfClassmates = new ArrayList<>();
    public List <Teacher> listOfTeachers = new ArrayList<>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;

    public int schoolLeavingExam(int intelligence, int wisdom){
        int basic_score = (intelligence+wisdom)/10 + (levelOfEducation+wealthOfPlace+prestigeOfPlace)/2 + random.nextInt(101);
        if(basic_score > 100)
            basic_score = 100;

        int extended_score = (intelligence+wisdom)/15+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/3 + random.nextInt(101);
        if(extended_score > 100)
            extended_score = 100;

        int examPoints = extended_score/7+basic_score/3;

        return examPoints;
    }


}
