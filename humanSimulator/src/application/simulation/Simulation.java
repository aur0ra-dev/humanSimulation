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

        for(int i = 0; mainCharacter.age < duration; i++){
            switch (i) {
                case 1, 2 -> progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.listOfTeachers);
                case 3 -> {
                    System.out.println("matka:" + mainCharacter.mother.loveToChildren);
                    System.out.println("stary:" + mainCharacter.father.attentionToChildren);
                    System.out.println("Your character is entering the Kindergarten");
                    mainCharacter.showFutures(mainCharacter);
                    kindergarten.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(kindergarten.listOfClassmates, 3, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.numberOfClassmates);
                    mainCharacter=kindergarten.careOverKid(mainCharacter);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.listOfTeachers);
                    progressStudents.progressClassmates(kindergarten.listOfClassmates, kindergarten.listOfTeachers);
                    checkIfEnd();
                }
                case 4, 5 -> {
                    mainCharacter=kindergarten.careOverKid(mainCharacter);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.listOfTeachers);
                    progressStudents.progressClassmates(kindergarten.listOfClassmates, kindergarten.listOfTeachers);
                    checkIfEnd();
                }
                case 6 -> {
                    System.out.println("Your character is entering the primarySchool");
                    mainCharacter.showFutures(mainCharacter);
                    kindergarten = null;
                    primaryschool.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(primaryschool.listOfClassmates, 6, mainCharacter.listOfFriends, mainCharacter.listOfBullies, primaryschool.numberOfClassmates);
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
                    mainCharacter=primaryschool.sendKidToContest(mainCharacter);
                    checkIfEnd();
                }
                case 14 -> {
                    mainCharacter.education = "basic";
                    System.out.println("Your character is entering the highSchool");
                    mainCharacter.showFutures(mainCharacter);
                    primaryschool = null;
                    highschool.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(highschool.listOfClassmates, 14, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.numberOfClassmates);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.listOfTeachers);
                    progressStudents.progressClassmates(highschool.listOfClassmates, highschool.listOfTeachers);
                    checkIfEnd();
                }
                case 15, 16 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.listOfTeachers);
                    progressStudents.progressClassmates(highschool.listOfClassmates, highschool.listOfTeachers);
                    checkIfEnd();
                }
                case 17 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.listOfTeachers);
                    progressStudents.progressClassmates(highschool.listOfClassmates, highschool.listOfTeachers);
                    mainCharacter.finalExamResults=highschool.schoolLeavingExam(mainCharacter.intelligence, mainCharacter.wisdom);
                    System.out.println("sredni: " + progressStudents.examinateClassmates(highschool.listOfClassmates,highschool));
                    System.out.println("mc: " + mainCharacter.finalExamResults);
                    if(progressStudents.examinateClassmates(highschool.listOfClassmates,highschool)>mainCharacter.finalExamResults) {
                        System.out.println("sadly our person didn't qualify to college");
                        i+=10;
                    }
                    checkIfEnd();
                }
                case 18 -> {
                    mainCharacter.education = "secondary";
                    System.out.println("Your character is entering the College");
                    mainCharacter.showFutures(mainCharacter);
                    highschool = null;
                    college.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(college.listOfClassmates, 18, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.numberOfClassmates);
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
                    mainCharacter= college.apprenticeships(mainCharacter);
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.listOfTeachers);
                    progressStudents.progressClassmates(college.listOfClassmates, college.listOfTeachers);
                    checkIfEnd();
                }
                case 22 -> {
                    progressMainCharacter.progressMain(mainCharacter, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.listOfTeachers);
                    progressStudents.progressClassmates(college.listOfClassmates, college.listOfTeachers);
                    mainCharacter=college.thesisDefense(mainCharacter);
                    checkIfEnd();
                }
                case 23 -> {
                    mainCharacter = workplace.initializePlace(mainCharacter);
                    mainCharacter = workplace.doWork(mainCharacter);
                    checkIfEnd();
                }
                default -> {
                    mainCharacter = workplace.doWork(mainCharacter);
                    System.out.println("going to work");

                    checkIfEnd();
                }
            }
        }
    }


    public void checkIfEnd(){
        if(mainCharacter.age == duration){
            System.out.println("Our person lived long and happy life and gathered all this stuff: ");
            mainCharacter.showFutures(mainCharacter);
        }
        else if(mainCharacter.healthEvent==0) {
            System.out.println("sadly our person committed suicide");
            System.out.print(" mental:" + mainCharacter.mentalHealth);
        }
    }

}

