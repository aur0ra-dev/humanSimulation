package Application.Human.fromHuman;

import Application.Human.Human;

public class Teacher extends Human {




    public int abilityToTeach = random.nextInt(90)+11;
    public int yearsOfExperience = 0;

    public int shareWisdom() {

        return (abilityToTeach/10 + yearsOfExperience) + random.nextInt(20);
    }
}
