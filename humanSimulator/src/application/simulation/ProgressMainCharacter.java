package application.simulation;

import application.human.fromHuman.MainCharacter;
import application.human.fromHuman.Teacher;
import java.util.List;

/**
 * Klasa odpowiadajaca za przeliczanie wartosci progresu
 */

public class ProgressMainCharacter {

    /**
     * Metoda modifukuje pola obiektu klasy MainCharacter za pomoca metod obietkow klass Mather oraz father
     * wartosci modyfikowane sa rowniez za pomoca metod obiektu tej klasy
     * w zaleznosci od pola age
     * modifukje pole wisdom w zaleznosci od pol obiektow Teacher
     * @param mainCharacter obiekt klasy MainCharacter
     * @param teachers lista obiektow klasy Teacher
     * @return obiekt klasy MainCharacter
     */

    public MainCharacter progressMain (MainCharacter mainCharacter, List<Teacher> teachers) {


        if(mainCharacter.age<12) {
            mainCharacter.gatherFromParents();
            mainCharacter=mainCharacter.father.influenceKid(mainCharacter);
            mainCharacter=mainCharacter.mother.showLoveToKid(mainCharacter);
        }
        if(mainCharacter.age>2 && mainCharacter.age<19)
            mainCharacter.gatherFromFriends();
        mainCharacter.Reflections();
        mainCharacter.age++;

        for (Teacher teacher : teachers) mainCharacter.wisdom += teacher.shareWisdom();

        return mainCharacter;
    }

}
