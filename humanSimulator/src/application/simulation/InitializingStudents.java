package application.simulation;

import application.human.fromHuman.Classmate;
import java.util.List;
import java.util.Random;

public class InitializingStudents {

    public void initializeClassmates(List<Classmate> listToInitialize, int stage, List<Classmate> friends, List<Classmate> bullies, int numberOfClassmates){

        Random random = new Random();

        for(int j = 0; j < numberOfClassmates; j++){
            listToInitialize.add(new Classmate());
            listToInitialize.get(j).age=stage;
            listToInitialize.get(j).beFriend();
            listToInitialize.get(j).beBully();
            listToInitialize.get(j).gender = random.nextInt(1)+1;
            listToInitialize.get(j).charisma = random.nextInt(60) + stage*10 + random.nextInt((stage+1)*5);
            listToInitialize.get(j).strength = random.nextInt(60) + stage*10 + random.nextInt((stage+1)*5);
            listToInitialize.get(j).intelligence = random.nextInt(60) + stage*10 + random.nextInt((stage+1)*5);
            listToInitialize.get(j).wisdom = random.nextInt(100)+30*(stage-3)+ random.nextInt(80)*(stage-3);
            if(listToInitialize.get(j).isFriend)
                friends.add(listToInitialize.get(j));
            else if(listToInitialize.get(j).isBully)
                bullies.add(listToInitialize.get(j));
        }


    }

}
