package cezary.games;

import java.util.Scanner;

public class Menu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("Witam!\nWybierz opcje planszy\n1.Kółko i krzyżyk: plansza 3x3\n2.Kółko i krzyżyk: plansza 5x5\n3.Statki\n4.Wyjście");
            int choice = scanner.nextInt();
            int size = 0;
            switch (choice) {
                case 1:
                    size = 3;
                    System.out.println("Kółko i krzyżyk: plansza 3x3");
                    Board.gameStartingBoxes(size);

                    break;
                case 2:
                    size = 5;
                    System.out.println("In Progress");
                    break;
                case 3:
                    System.out.println("Statki");
                    Ships.shipsArrays();
                case 4:
                    loop = false;

            }


        }

    }
}
