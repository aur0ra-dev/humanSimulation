package application.places;


import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Worker;

import java.util.Objects;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa reprezentuja miejsce pracy
 */
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

    /**
     * Metoda w zaelznosi od pol obiektu klasy MainCharaceter i losowo generowanych wartosci inicjalizuje startowe zarobki oraz ich
     * skalowalnosc
     * tworzy nowe obiekty klasy Worker oraz inicjalizuje wartosci pol tych obiektow
     * @param mainCharacter przyjmuje obiket klasy MainCharacter
     * @return zwraca obiekt klasy MainCharacter
     */

    public MainCharacter initializePlace (MainCharacter mainCharacter) {

        if(Objects.equals(mainCharacter.education, "higher"))
            startingEarnings = 5000 + random.nextInt(5000+mainCharacter.wisdom) + random.nextInt(mainCharacter.bonusesToEarnings);
        else
            startingEarnings = 2000 + random.nextInt(2000) + random.nextInt(mainCharacter.bonusesToEarnings);

        scallingOfEarnings = mainCharacter.bonusesToEarnings+mainCharacter.wisdom+mainCharacter.intelligence*10;

        for(int j=0; j< 20 + random.nextInt(31); j++) {
            listOfCoWorkers.add(new Worker());
            listOfCoWorkers.get(j).age=random.nextInt(30)+18;
            listOfCoWorkers.get(j).gender = random.nextInt(1)+1;
            listOfCoWorkers.get(j).charisma = random.nextInt(250) + 160;
            listOfCoWorkers.get(j).strength = random.nextInt(250) + 160;
            listOfCoWorkers.get(j).intelligence = random.nextInt(250) + 160;
            listOfCoWorkers.get(j).wisdom = random.nextInt(250) + 160;
        }
        mainCharacter.earnings=startingEarnings;

        return mainCharacter;
    }
}
