package cezary.games;

import com.sun.javafx.css.SizeUnits;
import java.util.Scanner;

public class Ships {

    //Makes empty arrays for both players, one for ships and one for "shots"
    public static void shipsArrays() {
        String[][] shipsPlayer1 = new String[10][10];
        String[][] shipsPlayer2 = new String[10][10];
        String[][] shotPlayer1 = new String[10][10];
        String[][] shotPlayer2 = new String[10][10];
        Scanner scanner = new Scanner(System.in);

        for (int a = 0; a < shipsPlayer1.length; a++) {
            for (int b = 0; b < shipsPlayer1.length; b++) {
                shipsPlayer1[a][b] = ".";
                shipsPlayer2[a][b] = ".";
                shotPlayer1[a][b] = "~";
                shotPlayer2[a][b] = "~";
            }
        }
        makingShips(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, scanner);
    }
//Podczas rozmiesczania p1s4 będą -1 | Rozstawianie większych: Pytanie w którą stronę 
//o jeden kwadrat z blokadą na OutOfBound | Zestrzelony masz = wynik +1, jak 
//wynik =20, przegrana |  

    //This will let players set up their ships on the maps
    public static void makingShips(String[][] shipsPlayer1, String[][] shipsPlayer2, String[][] shotPlayer1, String[][] shotPlayer2, Scanner scanner) {
        int turn = 1;
        int p1s1 = 1;
        int p2s1 = 1;
        System.out.println("Rozmieść swoje statki. Aby podać koordynaty, wpisz pierw literę, potem cyfrę.");
        boolean bothPlayers = true;
        boolean gameplay = true;
        boolean setup = true;
        while (bothPlayers) {
            if (p1s1 != 0) {
                System.out.println("Pierwszy\n");
                playerTurns(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, turn, scanner, setup, gameplay);
                p1s1 -= 1;
                if (p1s1 == 0) {
                    turn += 1;
                }
            } else if (p2s1 != 0) {
                System.out.println("drugi\n");
                playerTurns(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, turn, scanner, setup, gameplay);
                p2s1 -= 1;
                if (p2s1 == 0) {
                    turn += 1;
                }
            } else {
                bothPlayers = false;
            }
        }
        while (gameplay) {
            setup = false;
            playerTurns(shipsPlayer1, shipsPlayer2, shotPlayer1, shotPlayer2, turn, scanner, setup, gameplay);
            turn += 1;
        }

    }

    //Asks for coordinates
    public static void coordinates(Scanner scanner, String[][] myTable, String[][] myShotsTable, String[][] enemyTable, Boolean setup, Boolean gameplay) {
        String position = scanner.next();
        int horizontal = 0;
        int vertical = 0;
        switch (position.toLowerCase().charAt(0)) {
            case 'a':
                vertical = 0;
                break;
            case 'b':
                vertical = 1;
                break;
            case 'c':
                vertical = 2;
                break;
            case 'd':
                vertical = 3;
                break;
            case 'e':
                vertical = 4;
                break;
            case 'f':
                vertical = 5;
                break;
            case 'g':
                vertical = 6;
                break;
            case 'h':
                vertical = 7;
                break;
            case 'i':
                vertical = 8;
                break;
            case 'j':
                vertical = 9;
                break;
        }

        if (position.charAt(position.length() - 1) - '0' == 0) {
            horizontal = 9;
        } else {
            horizontal = position.charAt(position.length() - 1) - '0' - 1;

        }
        if (setup) {
            if (myTable[horizontal][vertical].equals(".")) {
                myTable[horizontal][vertical] = "0";
            }
        } else if (gameplay) {
            System.out.println("test");
            if (enemyTable[horizontal][vertical].equals("0")) {
                enemyTable[horizontal][vertical] = "X";
                myShotsTable[horizontal][vertical] = "X";
                System.out.println("Trafiony!");
            } else if (enemyTable[horizontal][vertical].equals(".")) {
                enemyTable[horizontal][vertical] = "v";
                myShotsTable[horizontal][vertical] = "v";
                System.out.println("Pudło!");
            }

        }
    }

    //This changes variables for each player's turn
    public static void playerTurns(String[][] shipsPlayer1, String[][] shipsPlayer2, String[][] shotPlayer1, String[][] shotPlayer2, Integer turn, Scanner scanner, Boolean setup, Boolean gameplay) {

        if (turn % 2 == 1) {
            String player = "Gracz 1";
            String[][] myTable = shipsPlayer1;
            String[][] myShotsTable = shotPlayer1;
            String[][] enemyTable = shipsPlayer2;
            tablesGenerator(player, myTable, myShotsTable);
            coordinates(scanner, myTable, myShotsTable, enemyTable, setup, gameplay);
        } else if (turn % 2 == 0) {
            String player = "Gracz 2";
            String[][] myTable = shipsPlayer2;
            String[][] myShotsTable = shotPlayer2;
            String[][] enemyTable = shipsPlayer1;
            tablesGenerator(player, myTable, myShotsTable);
            coordinates(scanner, myTable, myShotsTable, enemyTable, setup, gameplay);
        }

    }

    //Prints out both maps for the active player, the one with his shots and with his ships
    public static void tablesGenerator(String player, String[][] myTable, String[][] myShotsTable) {
        System.out.println(player);
        System.out.println("XX|A|B|C|D|E|F|G|H|I|J   |   XX|A|B|C|D|E|F|G|H|I|J");
        String q = "|";
        for (int a = 0; a < myTable.length; a++) {
            String position = String.format("%02d", a + 1);
            System.out.print(position);
            for (int b = 0; b < myTable.length; b++) {
                System.out.print(q + myTable[a][b]);
                if (b == 9) {
                    System.out.print("   |   ");
                    System.out.print(position);
                    for (int c = 0; c < myShotsTable[a].length; c++) {
                        System.out.print(q + myShotsTable[a][c]);
                        if (c == 9) {
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
