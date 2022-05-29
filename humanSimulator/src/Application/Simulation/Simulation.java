package Application.Simulation;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.MainCharacter;
import Application.Human.fromHuman.Teacher;
import Application.Places.Kindergarten;
import java.util.Random;

import java.util.Scanner;

public class Simulation {
    public int duration;
    MainCharacter mainCharacter = new MainCharacter();
    Kindergarten kindergarten = new Kindergarten();
    Primar


    public void startSimulation(){
        Random random = new Random();
        System.out.println("Welcome to human simulator! Assemble the basic futures of our Main characeter");
        Scanner name = new Scanner(System.in);
        String characterName;
        System.out.println("Input the name of our main character: ");
        characterName = name.nextLine();
        mainCharacter.name = characterName;
        Scanner surname = new Scanner(System.in);
        String characterSurname;
        System.out.println("Input the surname of our main character: ");
        characterSurname = name.nextLine();
        mainCharacter.surname = characterSurname;
        System.out.println(mainCharacter.charisma);
        for(int i = 0; i < duration ;i ++){
            if(mainCharacter.age == 3){


                for(int j = 0; j <= 15 + random.nextInt(11); j++){
                    kindergarten.listOfClassmates.add(new Classmate());

                }
                kindergarten.listOfTeachers.add(new Teacher());
            }

            if(mainCharacter.age == 6){
                kindergarten = null;
                // primary school + funkcje
            }
            if(mainCharacter.age == 14){
                // szkola srednia + funckje
            }
            if(mainCharacter.age == 18){
                // praca albo college + funckje
            }
            if(mainCharacter.age == 24){
                // workPlace
            }
            checkIfEnd();
        }



    }
    public void makeTurn(){
        mainCharacter.age +=1;


    }

    public boolean checkIfEnd(){
        if(mainCharacter.age == duration){
            endSimulation();
            return true;
        }else{
            makeTurn();
            return false;
        }
    }

    public void endSimulation(){
        System.out.println("Our person lived long and happy life and gathered all this stuff: ");
        // wyswietlanie wartosci obiektu;



    }

}
