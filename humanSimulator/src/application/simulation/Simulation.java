package application.simulation;

import application.human.fromHuman.MainCharacter;
import application.places.*;

import java.util.Random;

import java.util.Scanner;

public class Simulation {
    public int duration = 30;
    MainCharacter mainCharacter = new MainCharacter();
    PrimarySchool primaryschool = new PrimarySchool();
    Kindergarten kindergarten = new Kindergarten();
    HighSchool highschool = new HighSchool();
    College college = new College();
    Workplace workplace = new Workplace();

    InitializingStudents initializator = new InitializingStudents();
    ProgressStudents studProgressor = new ProgressStudents();
    ProgressMainCharacter mainProgressor = new ProgressMainCharacter();

    public void startSimulation(){


        Scanner scanner = new Scanner(System.in);

        mainCharacter.age = 1;
        int ticker = 0;
        Random random = new Random();
        System.out.println("Welcome to human simulator! Assemble the basic futures of our Main characeter");
        System.out.println("Input the name of our main character: ");
        mainCharacter.name = scanner.nextLine();
        System.out.println("Input the surname of our main character: ");
        mainCharacter.surname = scanner.nextLine();
        System.out.println("Input the Strength(choose between 40 and 100) of our main character: ");
        mainCharacter.strength = scanner.nextInt();

        if(mainCharacter.strength>100)
            mainCharacter.strength=100;
        else if(mainCharacter.strength<40)
            mainCharacter.strength=40;


        System.out.println("Input the Intelligence(choose between 40 and 100) of our main character: ");
        mainCharacter.intelligence = scanner.nextInt();

        if(mainCharacter.intelligence>100)
            mainCharacter.intelligence=100;
        else if(mainCharacter.intelligence<40)
            mainCharacter.intelligence=40;

        System.out.println("Input the Wisdom(choose between 40 and 100) of our main character: ");
        mainCharacter.wisdom = scanner.nextInt();

        if(mainCharacter.wisdom>100)
            mainCharacter.wisdom=100;
        else if(mainCharacter.wisdom<40)
            mainCharacter.wisdom=40;

        System.out.println("Input the Charisma(choose between 40 and 100) of our main character: ");
        mainCharacter.charisma = scanner.nextInt();

        if(mainCharacter.charisma>100)
            mainCharacter.charisma=100;
        else if(mainCharacter.charisma<40)
            mainCharacter.charisma=40;

        System.out.println("Choose gender of our main character(1 stands for male, 2 stands for female) of our main character: ");
        mainCharacter.gender = scanner.nextInt();

        if(mainCharacter.gender!=2 || mainCharacter.gender!=1) {
            mainCharacter.gender=1;
        }

        System.out.println("Allmighty god of Java human simulation blessed you with that Personal traits");
        mainCharacter.showFutures(mainCharacter);

        for(int i = 0; i < duration; i++){
            switch(mainCharacter.age) {
                case 1:
                    checkIfEnd();
                    break;
                case 2:
                    checkIfEnd();
                    break;
                case 3:
                    kindergarten.initializePlace(mainCharacter);
                    initializator.initializeClassmates(kindergarten.listOfClassmates,1,mainCharacter.listOfFriends,mainCharacter.listOfBullies,kindergarten.numberOfClassmates);
                    kindergarten.careOverKid(mainCharacter);
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,kindergarten.listOfTeachers);
                    studProgressor.progressClassmates(kindergarten.listOfClassmates,kindergarten.listOfTeachers);
                    checkIfEnd();
                    break;
                case 4-5:
                    kindergarten.careOverKid(mainCharacter);
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,kindergarten.listOfTeachers);
                    studProgressor.progressClassmates(kindergarten.listOfClassmates,kindergarten.listOfTeachers);
                    checkIfEnd();
                    break;
                case 6:
                    System.out.println("Your character is entering the primarySchool");
                    kindergarten = null; // smieciara tududu
                    primaryschool.initializePlace(mainCharacter);
                    initializator.initializeClassmates(primaryschool.listOfClassmates,2,mainCharacter.listOfFriends,mainCharacter.listOfBullies,primaryschool.numberOfClassmates);
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,primaryschool.listOfTeachers);
                    studProgressor.progressClassmates(primaryschool.listOfClassmates,primaryschool.listOfTeachers);
                    checkIfEnd();
                    break;
                case 7-12:
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,primaryschool.listOfTeachers);
                    studProgressor.progressClassmates(primaryschool.listOfClassmates,primaryschool.listOfTeachers);
                    checkIfEnd();
                    break;
                case 13:
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,primaryschool.listOfTeachers);
                    studProgressor.progressClassmates(primaryschool.listOfClassmates,primaryschool.listOfTeachers);
                    primaryschool.sendKidToContest(mainCharacter);
                    checkIfEnd();
                    break;
                case 14:
                    System.out.println("Your character is entering the highSchool");
                    primaryschool = null;
                    highschool.initializePlace(mainCharacter);
                    initializator.initializeClassmates(highschool.listOfClassmates,3,mainCharacter.listOfFriends,mainCharacter.listOfBullies,highschool.numberOfClassmates);
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,highschool.listOfTeachers);
                    studProgressor.progressClassmates(highschool.listOfClassmates,highschool.listOfTeachers);
                    checkIfEnd();
                    break;
                case 15-17:
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,highschool.listOfTeachers);
                    studProgressor.progressClassmates(highschool.listOfClassmates,highschool.listOfTeachers);
                    checkIfEnd();
                    break;
                case 18:
                    System.out.println("Your character is entering the College");
                    highschool = null;

                    college.initializePlace(mainCharacter);
                    initializator.initializeClassmates(college.listOfClassmates,4,mainCharacter.listOfFriends,mainCharacter.listOfBullies,college.numberOfClassmates);
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,college.listOfTeachers);
                    studProgressor.progressClassmates(college.listOfClassmates,college.listOfTeachers);
                    checkIfEnd();
                    break;
                case 19:
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,college.listOfTeachers);
                    studProgressor.progressClassmates(college.listOfClassmates,college.listOfTeachers);
                    checkIfEnd();
                    break;
                case 20:
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,college.listOfTeachers);
                    studProgressor.progressClassmates(college.listOfClassmates,college.listOfTeachers);
                    checkIfEnd();
                    break;
                case 21:
                    college.Apprenticeships(mainCharacter);
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,college.listOfTeachers);
                    studProgressor.progressClassmates(college.listOfClassmates,college.listOfTeachers);
                    checkIfEnd();
                    break;
                case 22:
                    mainProgressor.progressMain(mainCharacter,mainCharacter.listOfFriends,mainCharacter.listOfBullies,college.listOfTeachers);
                    studProgressor.progressClassmates(college.listOfClassmates,college.listOfTeachers);
                    checkIfEnd();
                    break;
                default:
                    //work
                    checkIfEnd();

            }

        }

    }
    public void makeTurn(){

        if(mainCharacter.age<12)
            mainCharacter.gatherFromParents();
        if(mainCharacter.age>2 && mainCharacter.age<19)
            mainCharacter.gatherFromFriends();
        mainCharacter.Reflections();
        mainCharacter.age++;
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


  /*
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */
        /*
        for(int i = 0; i <= duration ;i ++){
            /*
            if(mainCharacter.age < 18 && mainCharacter.age > 1){ //implementcja opieki od rodzicow

            }



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
                ticker = 1;
                highschool = null;

                college = null;
            }
            if(mainCharacter.age == 24 && ticker == 0){
                System.out.println("after long 6 years of college you finally get your dreamed job");
                college = null;

            }
            checkIfEnd();
        }

          */