package application.places;


import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Worker;

import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Workplace {

    Random random = new Random();
    public int scallingOfEarnings;
    public int startingEarnings;
    public List<Worker> listOfCoWorkers = new ArrayList<>();




    public MainCharacter doWork(MainCharacter mainCharacter){

        int avgProductivity=0;
        if(listOfCoWorkers.size()>0) {
            for (Worker listOfCoWorker : listOfCoWorkers) {
                avgProductivity += listOfCoWorker.productivity;
            }
            avgProductivity = avgProductivity / listOfCoWorkers.size() + random.nextInt(25);
            scallingOfEarnings += avgProductivity * random.nextInt(15);
        }

        mainCharacter.earnings += scallingOfEarnings/50;
        mainCharacter.age++;
        return mainCharacter;
    }

    public MainCharacter initializePlace (MainCharacter mainCharacter) {

        if(Objects.equals(mainCharacter.education, "higher"))
            startingEarnings = 5000 + random.nextInt(5000+mainCharacter.wisdom) + random.nextInt(mainCharacter.bonusesToEarnings);
        else
            startingEarnings = 2000 + random.nextInt(2000) + random.nextInt(mainCharacter.bonusesToEarnings);

        scallingOfEarnings = mainCharacter.bonusesToEarnings+mainCharacter.wisdom+mainCharacter.intelligence*10;

        for(int i=0; i< 20 + random.nextInt(31); i++) {
            listOfCoWorkers.add(new Worker());
        }

        mainCharacter.earnings=startingEarnings;

        return mainCharacter;
    }
}
