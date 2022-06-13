package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.List;

public class ProgressMainCharacter {

    public MainCharacter progressMain (MainCharacter mainCharacter, List<Classmate> friends, List<Classmate> bullies, List<Teacher> teachers) {


        if(mainCharacter.age<12)
            mainCharacter.gatherFromParents();
        if(mainCharacter.age>2 && mainCharacter.age<19)
            mainCharacter.gatherFromFriends();
        mainCharacter.Reflections();
        mainCharacter.age++;

        for(int i=0;i<teachers.size();i++)
            mainCharacter.wisdom+=teachers.get(i).shareWisdom();


        return mainCharacter;
    }

}
