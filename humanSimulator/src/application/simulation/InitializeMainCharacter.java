package application.simulation;

import application.human.fromHuman.MainCharacter;

import java.util.Scanner;

public class InitializeMainCharacter {

    int startingValues() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        if(a >100)
            return 100;
        else return Math.max(a, 40);
    }

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
        mainCharacter.strength = startingValues();
        System.out.print("Input the Intelligence(choose between 40 and 100) of our main character: ");
        mainCharacter.intelligence = startingValues();
        System.out.print("Input the Wisdom(choose between 40 and 100) of our main character: ");
        mainCharacter.wisdom = startingValues();
        System.out.print("Input the Charisma(choose between 40 and 100) of our main character: ");
        mainCharacter.charisma = startingValues();

        System.out.print("Choose gender of our main character(1 stands for male, 2 stands for female) of our main character: ");
        mainCharacter.gender = scanner.nextInt();

        if(mainCharacter.gender!=2 && mainCharacter.gender!=1)
            mainCharacter.gender = 1;

            return mainCharacter;

    }



}
