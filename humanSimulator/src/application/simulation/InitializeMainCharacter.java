package application.simulation;

import application.human.fromHuman.MainCharacter;

import java.util.Scanner;

public class InitializeMainCharacter {

    MainCharacter mainInitialization (MainCharacter mainCharacter) {
        Scanner scanner = new Scanner(System.in);

        mainCharacter.mentalHealth=70;
        mainCharacter.age = 0;
        System.out.println("Welcome to human simulator! Assemble the basic futures of our Main characeter");
        System.out.print("Input the name of our main character: ");
        mainCharacter.name = scanner.nextLine();
        System.out.print("Input the surname of our main character: ");
        mainCharacter.surname = scanner.nextLine();
        System.out.print("Input the Strength(choose between 40 and 100) of our main character: ");
        mainCharacter.strength = scanner.nextInt();

        if(mainCharacter.strength>100)
            mainCharacter.strength=100;
        else if(mainCharacter.strength<40)
            mainCharacter.strength=40;

        System.out.print("Input the Intelligence(choose between 40 and 100) of our main character: ");
        mainCharacter.intelligence = scanner.nextInt();

        if(mainCharacter.intelligence>100)
            mainCharacter.intelligence=100;
        else if(mainCharacter.intelligence<40)
            mainCharacter.intelligence=40;

        System.out.print("Input the Wisdom(choose between 40 and 100) of our main character: ");
        mainCharacter.wisdom = scanner.nextInt();

        if(mainCharacter.wisdom>100)
            mainCharacter.wisdom=100;
        else if(mainCharacter.wisdom<40)
            mainCharacter.wisdom=40;

        System.out.print("Input the Charisma(choose between 40 and 100) of our main character: ");
        mainCharacter.charisma = scanner.nextInt();

        if(mainCharacter.charisma>100)
            mainCharacter.charisma=100;
        else if(mainCharacter.charisma<40)
            mainCharacter.charisma=40;

        System.out.print("Choose gender of our main character(1 stands for male, 2 stands for female) of our main character: ");
        mainCharacter.gender = scanner.nextInt();

        if(mainCharacter.gender!=2 && mainCharacter.gender!=1)
            mainCharacter.gender = 1;

            return mainCharacter;

    }



}
