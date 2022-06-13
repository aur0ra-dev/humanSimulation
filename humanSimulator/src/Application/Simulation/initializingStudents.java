package Application.Simulation;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.MainCharacter;

import java.util.List;
import java.util.Random;

public class initializingStudents {

    public void initializeClassmates(List<Classmate> listToInitialize, int stage){

        Random random = new Random();

        for(int j = 0; j < listToInitialize.size(); j++){
            listToInitialize.get(j).gender = random.nextInt(1)+1;
            listToInitialize.get(j).charisma = random.nextInt(60)+(40*stage);
            listToInitialize.get(j).strength = random.nextInt(60)+(40*stage);
            listToInitialize.get(j).intelligence = random.nextInt(60)+(40*stage);
            listToInitialize.get(j).wisdom = random.nextInt(100)+(80*(stage-1));
        }


    }

}
