package application.simulation;

import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;
import java.util.List;

public class ProgressMainCharacter {

    public MainCharacter progressMain (MainCharacter mainCharacter, List<Teacher> teachers) {


        if(mainCharacter.age<12) {
            mainCharacter.gatherFromParents();
            mainCharacter=mainCharacter.father.influenceKid(mainCharacter);
            mainCharacter=mainCharacter.mother.showLoveToKid(mainCharacter);
        }
        if(mainCharacter.age>2 && mainCharacter.age<19)
            mainCharacter.gatherFromFriends();
        mainCharacter.Reflections();
        mainCharacter.age++;

        for (Teacher teacher : teachers) mainCharacter.wisdom += teacher.shareWisdom();

        return mainCharacter;
    }

}
