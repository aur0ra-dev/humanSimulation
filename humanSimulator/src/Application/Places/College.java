package Application.Places;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.MainCharacter;
import Application.Human.fromHuman.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class College {

    Random random = new Random();

    public List <Classmate> listOfClassmates = new ArrayList<>();
    public List<Teacher> listOfTeachers = new ArrayList<Application.Human.fromHuman.Teacher>();
    public int levelOfEducation;
    public int wealthOfPlace;
    public int prestigeOfPlace;

    public void Apprenticeships(MainCharacter mainCharacter){
        if(mainCharacter.age == 22)
        mainCharacter.bonusesToEarnings=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*200;

    }
    public void Session(MainCharacter mainCharacter){
        if(((mainCharacter.intelligence+mainCharacter.wisdom)/15+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/3 + random.nextInt(101))<50) {
            //drop z uni
        }

    }
    public void thesisDefense(MainCharacter mainCharacter){
        if(((mainCharacter.intelligence+mainCharacter.wisdom)/20+(levelOfEducation+wealthOfPlace+prestigeOfPlace)/4 + random.nextInt(101))>50) {
            mainCharacter.bonusesToEarnings=((levelOfEducation+wealthOfPlace+prestigeOfPlace)+random.nextInt(25)+1)*350;
        } else {
            // drop z uni
        }
    }

}
