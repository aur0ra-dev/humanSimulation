package application.simulation;

import application.human.fromHuman.Classmate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Klasa odpowiadajaca za inicjalizacje
 */
public class InitializingStudents {

    /**
     * Metoda ktora za pomoca klasy file oraz Scanner wcztytuje wartosci z plikue oraz inicjalizuje pole obiektow klasy Classmate
     * Za pomoca petli dla kazdego z obiektow przypisuje losowo generowane wartosci dla odpowiednich pol
     * @param listToInitialize lista przeznaczona do inicjalizacji
     * @param stage etap edukacji
     * @param friends przyjadziele
     * @param bullies wrogowie/osoby znecajace sie
     * @param numberOfClassmates ilosc kolegow z klasy
     */
    public void initializeClassmates(List<Classmate> listToInitialize, int stage, List<Classmate> friends, List<Classmate> bullies, int numberOfClassmates) {

        Random random = new Random();
        List<String> namesF = new ArrayList<>();
        List<String> namesM = new ArrayList<>();
        try {
            File myObj = new File("namesF.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                namesF.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("namesM.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                namesM.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int j = 0; j < numberOfClassmates; j++) {
            listToInitialize.add(new Classmate());
            listToInitialize.get(j).age = stage;
            listToInitialize.get(j).beFriend();
            listToInitialize.get(j).beBully();
            listToInitialize.get(j).gender = random.nextInt(2);
            listToInitialize.get(j).charisma = random.nextInt(60) + stage * 10 + random.nextInt((stage + 1) * 5);
            listToInitialize.get(j).strength = random.nextInt(60) + stage * 10 + random.nextInt((stage + 1) * 5);
            listToInitialize.get(j).intelligence = random.nextInt(60) + stage * 10 + random.nextInt((stage + 1) * 5);
            listToInitialize.get(j).wisdom = random.nextInt(100) + 30 * (stage - 3) + random.nextInt(80) * (stage - 3);
            if (listToInitialize.get(j).isFriend) {
                friends.add(listToInitialize.get(j));
            } else if (listToInitialize.get(j).isBully) {
                bullies.add(listToInitialize.get(j));
            }
            if(listToInitialize.get(j).gender == 1){
                listToInitialize.get(j).name = namesF.get(random.nextInt(namesF.size()));
            }else if(listToInitialize.get(j).gender == 0){
                listToInitialize.get(j).name = namesM.get(random.nextInt(namesM.size()));
            }


        }






        }
    }

