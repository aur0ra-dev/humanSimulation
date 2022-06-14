package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;
import application.places.*;
import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public int duration = 30;
    List<Classmate> emptyList = new ArrayList<>();
    List<Teacher> emptyList2 = new ArrayList<>();
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
    Comparisons comparator = new Comparisons();

    public void startSimulation(){


        mainCharacter = initializeMainCharacter.mainInitialization(mainCharacter);

        for(int i = 0; mainCharacter.age < duration; i++){
            switch (i) {
                case 1, 2 -> progressMainCharacter.progressMain(mainCharacter, emptyList2);
                case 3 -> {
                    System.out.println("Your character is entering the Kindergarten");
                    kindergarten.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(kindergarten.listOfClassmates, 3, mainCharacter.listOfFriends, mainCharacter.listOfBullies, kindergarten.numberOfClassmates);
                    mainCharacter=kindergarten.careOverKid(mainCharacter);
                    checkIfEnd(kindergarten.listOfClassmates,kindergarten.listOfTeachers);
                }
                case 4, 5 -> {
                    mainCharacter=kindergarten.careOverKid(mainCharacter);
                    checkIfEnd(kindergarten.listOfClassmates,kindergarten.listOfTeachers);
                }
                case 6 -> {
                    System.out.println("Your character is entering the primarySchool");
                    comparator.compare(mainCharacter,kindergarten.listOfClassmates);
                    comparator.showcase(comparator.strengthDif, comparator.intelligenceDif,comparator.wisdomDif, comparator.charismaDif, mainCharacter.age);
                    kindergarten = null;
                    primaryschool.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(primaryschool.listOfClassmates, 6, mainCharacter.listOfFriends, mainCharacter.listOfBullies, primaryschool.numberOfClassmates);
                    checkIfEnd(primaryschool.listOfClassmates, primaryschool.listOfTeachers);
                }
                case 7, 8, 9, 10, 11, 12 -> checkIfEnd(primaryschool.listOfClassmates, primaryschool.listOfTeachers);
                case 13 -> {
                    mainCharacter=primaryschool.sendKidToContest(mainCharacter);
                    checkIfEnd(primaryschool.listOfClassmates, primaryschool.listOfTeachers);
                }
                case 14 -> {
                    mainCharacter.education = "basic";
                    System.out.println("Your character is entering the highSchool");
                    comparator.compare(mainCharacter,primaryschool.listOfClassmates);
                    comparator.showcase(comparator.strengthDif, comparator.intelligenceDif,comparator.wisdomDif, comparator.charismaDif, mainCharacter.age);
                    primaryschool = null;
                    highschool.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(highschool.listOfClassmates, 14, mainCharacter.listOfFriends, mainCharacter.listOfBullies, highschool.numberOfClassmates);
                    checkIfEnd(highschool.listOfClassmates, highschool.listOfTeachers);
                }
                case 15, 16 -> checkIfEnd(highschool.listOfClassmates, highschool.listOfTeachers);
                case 17 -> {
                    checkIfEnd(highschool.listOfClassmates, highschool.listOfTeachers);
                    mainCharacter.finalExamResults=highschool.schoolLeavingExam(mainCharacter.intelligence, mainCharacter.wisdom);
                    if(progressStudents.examinateClassmates(highschool.listOfClassmates,highschool)>mainCharacter.finalExamResults) {
                        i=22;
                        comparator.compare(mainCharacter,highschool.listOfClassmates);
                        comparator.showcase(comparator.strengthDif, comparator.intelligenceDif,comparator.wisdomDif, comparator.charismaDif, mainCharacter.age);
                        System.out.println("sadly our person didn't qualify to college");
                        mainCharacter.education = "secondary";
                    }
                }
                case 18 -> {
                    mainCharacter.education = "secondary";
                    comparator.compare(mainCharacter,highschool.listOfClassmates);
                    comparator.showcase(comparator.strengthDif, comparator.intelligenceDif,comparator.wisdomDif, comparator.charismaDif, mainCharacter.age);
                    System.out.println("Your character is entering the College");
                    highschool = null;
                    college.initializePlace(mainCharacter);
                    initializingStudents.initializeClassmates(college.listOfClassmates, 18, mainCharacter.listOfFriends, mainCharacter.listOfBullies, college.numberOfClassmates);
                    checkIfEnd(college.listOfClassmates, college.listOfTeachers);
                }
                case 19, 20 -> {
                    if(college.session(mainCharacter)==0) {
                        i = 22;
                    }
                    checkIfEnd(college.listOfClassmates, college.listOfTeachers);
                }
                case 21 -> {
                    mainCharacter= college.apprenticeships(mainCharacter);
                    checkIfEnd(college.listOfClassmates, college.listOfTeachers);
                }
                case 22 -> {
                    checkIfEnd(college.listOfClassmates, college.listOfTeachers);
                    mainCharacter=college.thesisDefense(mainCharacter);
                    comparator.compare(mainCharacter,college.listOfClassmates);
                    comparator.showcase(comparator.strengthDif, comparator.intelligenceDif,comparator.wisdomDif, comparator.charismaDif, mainCharacter.age);
                }
                case 23 -> {
                    college = null;
                    System.out.println("Your character goes to work!");
                    mainCharacter = workplace.initializePlace(mainCharacter);
                    mainCharacter = workplace.doWork(mainCharacter);
                    checkIfEnd(emptyList,emptyList2);
                }
                default -> {
                    mainCharacter = workplace.doWork(mainCharacter);
                    checkIfEnd(emptyList,emptyList2);
                }
            }
        }
    }

    void checkIfEnd(List<Classmate> students, List<Teacher> teachers){
        if(mainCharacter.age == duration){
            mainCharacter.showStatistics();
            System.exit(0);
        }
        else if(mainCharacter.healthEvent==0) {
            System.out.println("sadly our person committed suicide at the age of " + mainCharacter.age + " due to mental health struggles");
            System.exit(0);
        }
        if(mainCharacter.age>20) {
            mainCharacter.seekLove();
        }
        if(students.size()>0) {
            progressStudents.progressClassmates(students, teachers);
            mainCharacter=progressMainCharacter.progressMain(mainCharacter, teachers);
        }
    }

}
