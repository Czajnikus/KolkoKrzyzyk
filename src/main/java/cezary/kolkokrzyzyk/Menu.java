package cezary.kolkokrzyzyk;

import java.awt.BorderLayout;
import java.util.Scanner;


public class Menu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("Witam!\nWybierz opcje planszy\n1.3x3\n2.5x5");
            int choice = scanner.nextInt();
            int size = 0;
            switch (choice) {
                case 1:
                    size = 3;
                    Board.gameStartingBoxes(size);
                    
                    break;
                case 2:
                    size = 5;
                    System.out.println("In Progress");;
                    break;

            }

            loop = false;

        }

    }
}
