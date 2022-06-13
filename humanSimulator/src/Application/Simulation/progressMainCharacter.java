package Application.Simulation;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.MainCharacter;
import Application.Human.fromHuman.Teacher;

import java.util.List;

public class progressMainCharacter {

    public MainCharacter progressMain (MainCharacter mainCharacter, List<Classmate> friends, List<Classmate> bullies, List<Teacher> teachers) {

        mainCharacter.gatherFromParents();
        mainCharacter.gatherFromFriends();
        mainCharacter.Reflections();

        for(int i=0;i<teachers.size();i++)
            mainCharacter.wisdom+=teachers.get(i).shareWisdom();


        return mainCharacter;
    }

}
