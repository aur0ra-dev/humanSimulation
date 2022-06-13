package Application.Simulation;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.Teacher;

import java.util.List;
import java.util.Random;

public class progressStudents {

    public void progressClassmates (List<Classmate> listToProgress, List<Teacher> teachingTeachers) {

        Random random = new Random();

        for(int i=0;i<listToProgress.size();i++) {

            listToProgress.get(i).age++;
            listToProgress.get(i).charisma += random.nextInt(10)+1;
            listToProgress.get(i).strength += random.nextInt(10)+1;
            listToProgress.get(i).intelligence += random.nextInt(10+1);
            listToProgress.get(i).wisdom +=random.nextInt(35)+1;

            for(int j = 0;j<teachingTeachers.size();j++) {
                listToProgress.get(i).wisdom+=teachingTeachers.get(j).shareWisdom();
            }
        }
    }

}
