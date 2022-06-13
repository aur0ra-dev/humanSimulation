package application.simulation;

import application.human.fromHuman.MainCharacter;
import application.places.*;

public class Simulation {
    public int duration = 30;
    MainCharacter mainCharacter = new MainCharacter();
    PrimarySchool primaryschool = new PrimarySchool();
    Kindergarten kindergarten = new Kindergarten();
    HighSchool highschool = new HighSchool();
    College college = new College();
    Workplace workplace = new Workplace();
    InitializingStudents initializingStudents = new InitializingStudents();
    ProgressStudents progressStudents = new ProgressStudents();
    ProgressMainCharacter progressMainCharacter = new ProgressMainCharacter();
    InitializeMainCharacter initializeMainCharacter = new InitializeMainCharacter();

    public void startSimulation(){


        mainCharacter = initializeMainCharacter.mainInitialization(mainCharacter);

        for(int i = 0; i < duration; i++){
            switch (i) {
                case 1, 2 -> progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.listOfTeachers);
                case 3 -> {
                    kindergarten.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(kindergarten.listOfClassmates, 1, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.numberOfClassmates);
                    kindergarten.careOverKid(mainCharacter);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.listOfTeachers);
                    progressStudents.progressClassmates(kindergarten.listOfClassmates, kindergarten.listOfTeachers);
                    checkIfEnd();
                }
                case 4, 5 -> {
                    kindergarten.careOverKid(mainCharacter);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.listOfTeachers);
                    progressStudents.progressClassmates(kindergarten.listOfClassmates, kindergarten.listOfTeachers);
                    checkIfEnd();
                }
                case 6 -> {
                    System.out.println("Your character is entering the primarySchool");
                    kindergarten = null;
                    primaryschool.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(primaryschool.listOfClassmates, 2, mainCharacter.listOfFriends, mainCharacter.listOfBullies, primaryschool.numberOfClassmates);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, primaryschool.listOfTeachers);
                    progressStudents.progressClassmates(primaryschool.listOfClassmates, primaryschool.listOfTeachers);
                    checkIfEnd();
                }
                case 7, 8, 9, 10, 11, 12 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, primaryschool.listOfTeachers);
                    progressStudents.progressClassmates(primaryschool.listOfClassmates, primaryschool.listOfTeachers);
                    checkIfEnd();
                }
                case 13 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, primaryschool.listOfTeachers);
                    progressStudents.progressClassmates(primaryschool.listOfClassmates, primaryschool.listOfTeachers);
                    primaryschool.sendKidToContest(mainCharacter);
                    checkIfEnd();
                }
                case 14 -> {
                    System.out.println("Your character is entering the highSchool");
                    primaryschool = null;
                    highschool.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(highschool.listOfClassmates, 3, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.numberOfClassmates);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.listOfTeachers);
                    progressStudents.progressClassmates(highschool.listOfClassmates, highschool.listOfTeachers);
                    checkIfEnd();
                }
                case 15, 16, 17 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.listOfTeachers);
                    progressStudents.progressClassmates(highschool.listOfClassmates, highschool.listOfTeachers);
                    checkIfEnd();
                }
                case 18 -> {
                    System.out.println("Your character is entering the College");
                    highschool = null;
                    college.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(college.listOfClassmates, 4, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.numberOfClassmates);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.listOfTeachers);
                    progressStudents.progressClassmates(college.listOfClassmates, college.listOfTeachers);
                    checkIfEnd();
                }
                case 19, 20 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.listOfTeachers);
                    progressStudents.progressClassmates(college.listOfClassmates, college.listOfTeachers);
                    checkIfEnd();
                }
                case 21 -> {
                    college.apprenticeships(mainCharacter);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.listOfTeachers);
                    progressStudents.progressClassmates(college.listOfClassmates, college.listOfTeachers);
                    checkIfEnd();
                }
                case 22 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.listOfTeachers);
                    progressStudents.progressClassmates(college.listOfClassmates, college.listOfTeachers);
                    college.thesisDefense(mainCharacter);
                    checkIfEnd();
                }
                case 23 -> {
                    workplace.initializePlace(mainCharacter);
                    checkIfEnd();
                }
                default -> {
                    //work
                    System.out.println("going to work");
                    checkIfEnd();
                }
            }
        }
    }


    public void checkIfEnd(){
        if(mainCharacter.age == duration){
            endSimulation();

        }
    }

    public void endSimulation(){
        System.out.println("Our person lived long and happy life and gathered all this stuff: ");
        mainCharacter.showFutures(mainCharacter); // printing statistics of mc
        System.out.println();

    }

}

