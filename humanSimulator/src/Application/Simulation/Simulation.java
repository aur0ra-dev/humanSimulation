package Application.Simulation;

import Application.Human.fromHuman.Classmate;
import Application.Human.fromHuman.MainCharacter;
import Application.Human.fromHuman.Teacher;
import Application.Places.*;

import java.util.Random;

import java.util.Scanner;

public class Simulation {
    public int duration = 30;
    MainCharacter mainCharacter = new MainCharacter();
    Kindergarten kindergarten = new Kindergarten();
    primarySchool primaryschool = new primarySchool();
    highSchool highschool = new highSchool();
    College college = new College();
    Workplace workplace = new Workplace();




    public void startSimulation(){
        Random random = new Random();
        System.out.println("Welcome to human simulator! Assemble the basic futures of our Main characeter");
        Scanner name = new Scanner(System.in);
        String characterName;
        mainCharacter.wisdom = 100; //testowa wartosc
        mainCharacter.intelligence = 100; //test
        System.out.println("Input the name of our main character: ");
        characterName = name.nextLine();
        mainCharacter.name = characterName;
        Scanner surname = new Scanner(System.in);
        String characterSurname;
        System.out.println("Input the surname of our main character: ");
        characterSurname = name.nextLine();
        mainCharacter.surname = characterSurname;
        mainCharacter.strength = random.nextInt(25)+1;
        System.out.println("Allmighty god of Java human simulation blessed you with that Personal traits");
        mainCharacter.showFutures(mainCharacter);
        /*
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */

        System.out.println(mainCharacter.strength);
        for(int i = 0; i <= duration ;i ++){
            /*
            if(mainCharacter.age < 18 && mainCharacter.age > 1){ //implementcja opieki od rodzicow

            }

             */

            if(mainCharacter.age == 3){
                System.out.println("Your character is entering the kindegarten");

                for(int j = 0; j <= 15 + random.nextInt(11); j++){
                    kindergarten.listOfClassmates.add(new Classmate());
                }
                kindergarten.listOfTeachers.add(new Teacher());
            }

            if(mainCharacter.age == 6){
                kindergarten = null; // smieciara tududu
                System.out.println("Your character is entering the primarySchool");
                for(int k = 0; k <= random.nextInt(11); k++){
                    primaryschool.listOfClassmates.add(new Classmate());
                }
                for(int g = 0; g < 4; g++){
                    primaryschool.listOfTeachers.add(new Teacher());
                }
            }
            if(mainCharacter.age == 14){
                System.out.println("Your character is entering the highSchool");
                primaryschool = null;
                for(int h = 0; h <= random.nextInt(11); h++){
                    highschool.listOfClassmates.add(new Classmate());
                }
                for(int v = 0; v < 4 ;v++){
                    highschool.listOfTeachers.add(new Teacher());
                }
                //highschool.schoolLeavingExam(mainCharacter.intelligence, mainCharacter.wisdom);
            }
            if(mainCharacter.age == 18 && highschool.schoolLeavingExam(mainCharacter.intelligence, mainCharacter.wisdom ) > 100 ){
                System.out.println("Congratulion your character was smart enough to get in to College");
                for(int n = 0; n <= random.nextInt(131)+50; n++){
                    college.listOfClassmates.add(new Classmate());
                }
                for(int m = 0; m < 15; m++){
                    college.listOfTeachers.add(new Teacher());
                }
                highschool = null;

            }
            if(mainCharacter.age == 18 && highschool.schoolLeavingExam(mainCharacter.intelligence, mainCharacter.wisdom ) < 100){
                System.out.println("What a dissapointment your characket didnt get to the College");
                System.out.println("You need to go to work");
                highschool = null;

                college = null;
            }
            if(mainCharacter.age == 24){
                System.out.println("after long 6 years of college you finally get your dreamed job");
                college = null;

            }
            checkIfEnd();
        }



    }
    public void makeTurn(){
        mainCharacter.age +=1;
        mainCharacter.strength =5;
        mainCharacter.charisma +=5;
        mainCharacter.intelligence +=5; // tymczasowa inkrementacja w celu test tbd srednie ze srodowisk
        mainCharacter.mentalHealth +=5;
        mainCharacter.mentalHealth +=5;
    }

    public void checkIfEnd(){
        if(mainCharacter.age == duration){
            endSimulation();

        }else{
            makeTurn();

        }
    }

    public void endSimulation(){
        System.out.println("Our person lived long and happy life and gathered all this stuff: ");
        // wyswietlanie wartosci obiektu;
        mainCharacter.showFutures(mainCharacter);
        System.out.println();

    }

}
