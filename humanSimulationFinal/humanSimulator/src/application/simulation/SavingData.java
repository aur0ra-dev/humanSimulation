package application.simulation;


import application.human.fromHuman.MainCharacter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SavingData {
    public void saveTofile(MainCharacter arg){
         {

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter("zapisz.txt", true));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try{
                writer.append(' ');
                writer.append(arg.name);
                writer.append(", ");
                writer.append(arg.surname);
                writer.append(", ");
                writer.append("age: " + (String.valueOf(arg.age)));
                writer.append(", ");
                writer.append("intelligence: " + (String.valueOf(arg.intelligence)));
                writer.append(", ");
                writer.append("gender: " + (String.valueOf(arg.gender)));
                writer.append(", ");
                writer.append("wisdom: " + (String.valueOf(arg.wisdom)));
                writer.append(", ");
                writer.append("charisma: " + (String.valueOf(arg.charisma)));
                writer.append(", ");
                writer.append("strenght: " + (String.valueOf(arg.strength)));
                writer.append(", ");
                writer.append("mentalHealth: " + (String.valueOf(arg.mentalHealth)));
                writer.append(", ");
                writer.append("earnings: " + (String.valueOf(arg.earnings)));
                writer.append(", ");
                writer.append("education: " + (String.valueOf(arg.education)));
                writer.append(", ");
                writer.append("having a Partner: " + (String.valueOf(arg.haveAPartner)));
                writer.append(", ");
                writer.append("List of friends: " + (arg.listOfFriends));
                writer.append("FinalExam result: " + (String.valueOf(arg.finalExamResults)));

                writer.append("\n");
                writer.close();
            }catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

