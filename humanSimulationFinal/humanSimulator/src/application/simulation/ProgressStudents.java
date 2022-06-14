package application.simulation;

import application.human.fromHuman.Classmate;
import application.human.fromHuman.Teacher;
import application.places.HighSchool;

import java.util.List;
import java.util.Random;

public class ProgressStudents {

    public void progressClassmates (List<Classmate> listToProgress, List<Teacher> teachingTeachers) {

        Random random = new Random();

        for (Classmate toProgress : listToProgress) {

            toProgress.age++;
            toProgress.charisma += random.nextInt(18) + 1;
            toProgress.strength += random.nextInt(22) + 1;
            toProgress.intelligence += random.nextInt(18 + 1);
            toProgress.wisdom += random.nextInt(55+(listToProgress.get(0).age)*9) + 1;

            for (Teacher teachingTeacher : teachingTeachers) {
                toProgress.wisdom += teachingTeacher.shareWisdom();
            }
        }
    }

    public int examinateClassmates (List<Classmate> listToExaminate, HighSchool highSchool) {
        int averageScore=0;
        for (Classmate classmate : listToExaminate) {
            classmate.finalExamResults = highSchool.schoolLeavingExam(classmate.intelligence, classmate.wisdom);
            averageScore+=classmate.finalExamResults;
        }
        return averageScore/(listToExaminate.size()+1);

    }

}
