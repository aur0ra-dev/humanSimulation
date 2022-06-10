package Application.Places;

import Application.Human.Human;
import Application.Human.fromHuman.Worker;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Workplace {

    Random random = new Random();
    public Human Boss = new Human();
    public int scallingOfEarnings;
    public int startingEarnings;
    public List<Worker> listOfCoWorkers = new ArrayList<>();
    public void doWork(){

        int avgProductivity=0;
        for(int i=0; i<listOfCoWorkers.size(); i++){
            avgProductivity+=listOfCoWorkers.get(i).productivity;
        }
        avgProductivity=avgProductivity/listOfCoWorkers.size() + random.nextInt(25);
        scallingOfEarnings+=avgProductivity*random.nextInt(15);
    }
}
