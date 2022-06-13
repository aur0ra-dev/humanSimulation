package application.simulation;

import application.human.fromHuman.Classmate;

import java.util.List;
import java.util.Random;

public class InitializingStudents {

    public void initializeClassmates(List<Classmate> listToInitialize, int stage, List<Classmate> friends, List<Classmate> bullies, int numberOfClassmates){

        Random random = new Random();

        for(int j = 0; j <= 15 + random.nextInt(11); j++){
            listToInitialize.add(new Classmate());
            listToInitialize.get(j).age=stage;
            listToInitialize.get(j).beFriend();
            listToInitialize.get(j).beBully();
            listToInitialize.get(j).gender = random.nextInt(1)+1;
            listToInitialize.get(j).charisma = random.nextInt(60)+(40*stage);
            listToInitialize.get(j).strength = random.nextInt(60)+(40*stage);
            listToInitialize.get(j).intelligence = random.nextInt(60)+(40*stage);
            listToInitialize.get(j).wisdom = random.nextInt(100)+(80*(stage-1));
            if(listToInitialize.get(j).isFriend)
                friends.add(listToInitialize.get(j));
            else if(listToInitialize.get(j).isBully)
                bullies.add(listToInitialize.get(j));
        }


    }

}
