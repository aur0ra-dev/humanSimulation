package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;

import java.util.List;

public class ProgressMainCharacter {

    public MainCharacter progressMain (MainCharacter mainCharacter, List<Classmate> friends, List<Classmate> bullies, List<Teacher> teachers) {

        mainCharacter.gatherFromParents();
        mainCharacter.gatherFromFriends();
        mainCharacter.Reflections();

        for(int i=0;i<teachers.size();i++)
            mainCharacter.wisdom+=teachers.get(i).shareWisdom();


        return mainCharacter;
    }

}
